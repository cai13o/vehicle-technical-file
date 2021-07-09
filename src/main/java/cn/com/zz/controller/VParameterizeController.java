package cn.com.zz.controller;


import cn.com.zz.entity.VParameterize;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVParameterizeService;
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
 * 车辆参数与配置登记表 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "车辆参数与配置登记表")
@RestController
@RequestMapping("/vparameterize")
public class VParameterizeController {

    @Resource
    private IVParameterizeService ivParameterizeService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VParameterize vParameterize) {
        if(this.ivParameterizeService.save(vParameterize)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VParameterize vParameterize = this.ivParameterizeService.getById(id);
        if(null != vParameterize){
            return Result.ok(ResultCodeEnum.SUCCESS,vParameterize);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VParameterize> vParameterizes = this.ivParameterizeService.list(new QueryWrapper<VParameterize>().eq("vin",vin));
        if(0 != vParameterizes.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vParameterizes);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VParameterize vParameterize) {
        if(this.ivParameterizeService.updateById(vParameterize)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VParameterize vParameterize) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivParameterizeService.list(new QueryWrapper<VParameterize>().setEntity(vParameterize)));
    }
}

