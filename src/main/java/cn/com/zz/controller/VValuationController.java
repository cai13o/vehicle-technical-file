package cn.com.zz.controller;


import cn.com.zz.entity.VValuation;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVValuationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 维修企业评价 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "维修企业评价")
@RestController
@RequestMapping("/vvaluation")
public class VValuationController {

    @Resource
    private IVValuationService ivValuationService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VValuation vValuation) {
        if(this.ivValuationService.save(vValuation)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VValuation vValuation = this.ivValuationService.getById(id);
        if(null != vValuation){
            return Result.ok(ResultCodeEnum.SUCCESS,vValuation);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VValuation vValuation) {
        if(this.ivValuationService.updateById(vValuation)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VValuation vValuation) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivValuationService.list(new QueryWrapper<VValuation>().setEntity(vValuation)));
    }

    @ApiOperation("删除数据")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result deleteByPrimaryKey(String id) {
        if(this.ivValuationService.removeById(id)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }
}

