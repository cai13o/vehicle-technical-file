package cn.com.zz.controller;


import cn.com.zz.entity.VInspectionReview;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVInspectionReviewService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 车辆检测与评审登记表 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "车辆检测与评审登记表")
@RestController
@RequestMapping("/vinspectionreview")
public class VInspectionReviewController {

    @Resource
    private IVInspectionReviewService ivInspectionReviewService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VInspectionReview vInspectionReview) {
        if(this.ivInspectionReviewService.save(vInspectionReview)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VInspectionReview vInspectionReview = this.ivInspectionReviewService.getById(id);
        if(null != vInspectionReview){
            return Result.ok(ResultCodeEnum.SUCCESS,vInspectionReview);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VInspectionReview> vInspectionReviews = this.ivInspectionReviewService.list(new QueryWrapper<VInspectionReview>().eq("vin",vin));
        if(0 != vInspectionReviews.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vInspectionReviews);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VInspectionReview vInspectionReview) {
        if(this.ivInspectionReviewService.updateById(vInspectionReview)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VInspectionReview vInspectionReview) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivInspectionReviewService.list(new QueryWrapper<VInspectionReview>().setEntity(vInspectionReview)));
    }
}

