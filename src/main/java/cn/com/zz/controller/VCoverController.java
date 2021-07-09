package cn.com.zz.controller;


import cn.com.zz.entity.VCover;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVCoverService;
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
 * 陕西省道路运输车辆技术档案 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "陕西省道路运输车辆技术档案")
@RestController
@RequestMapping("/vcover")
public class VCoverController {

    @Resource
    private IVCoverService ivCoverService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VCover vCover) {
        if(this.ivCoverService.save(vCover)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VCover vCover = this.ivCoverService.getById(id);
        if(null != vCover){
            return Result.ok(ResultCodeEnum.SUCCESS,vCover);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VCover> vCovers = this.ivCoverService.list(new QueryWrapper<VCover>().eq("vin",vin));
        if(0 != vCovers.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vCovers);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VCover vCover) {
        if(this.ivCoverService.updateById(vCover)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VCover vCover) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivCoverService.list(new QueryWrapper<VCover>().setEntity(vCover)));
    }
}

