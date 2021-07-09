package cn.com.zz.controller;


import cn.com.zz.entity.VsCommerialVehicle;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVsCommerialVehicleService;
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
 * 营运车辆 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "营运车辆")
@RestController
@RequestMapping("/vscommerialvehicle")
public class VsCommerialVehicleController {

    @Resource
    private IVsCommerialVehicleService ivsCommerialVehicleService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VsCommerialVehicle vsCommerialVehicle) {
        if(this.ivsCommerialVehicleService.save(vsCommerialVehicle)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VsCommerialVehicle vsCommerialVehicle = this.ivsCommerialVehicleService.getById(id);
        if(null != vsCommerialVehicle){
            return Result.ok(ResultCodeEnum.SUCCESS,vsCommerialVehicle);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        VsCommerialVehicle vsCommerialVehicle = this.ivsCommerialVehicleService.getOne(new QueryWrapper<VsCommerialVehicle>().eq("vin",vin));
        if(null != vsCommerialVehicle){
            return Result.ok(ResultCodeEnum.SUCCESS,vsCommerialVehicle);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VsCommerialVehicle vsCommerialVehicle) {
        if(this.ivsCommerialVehicleService.updateById(vsCommerialVehicle)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VsCommerialVehicle vsCommerialVehicle) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivsCommerialVehicleService.list(new QueryWrapper<VsCommerialVehicle>().setEntity(vsCommerialVehicle)));
    }
}

