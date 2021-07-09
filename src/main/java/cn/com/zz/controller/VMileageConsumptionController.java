package cn.com.zz.controller;


import cn.com.zz.entity.VMileageConsumption;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVMileageConsumptionService;
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
 * 车辆行驶里程与燃油消耗登记表 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "车辆行驶里程与燃油消耗登记表")
@RestController
@RequestMapping("/vmileageconsumption")
public class VMileageConsumptionController {

    @Resource
    private IVMileageConsumptionService ivMileageConsumptionService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VMileageConsumption vMileageConsumption) {
        if(this.ivMileageConsumptionService.save(vMileageConsumption)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VMileageConsumption vMileageConsumption = this.ivMileageConsumptionService.getById(id);
        if(null != vMileageConsumption){
            return Result.ok(ResultCodeEnum.SUCCESS,vMileageConsumption);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VMileageConsumption> vMileageConsumptions = this.ivMileageConsumptionService.list(new QueryWrapper<VMileageConsumption>().eq("vin",vin));
        if(0 != vMileageConsumptions.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vMileageConsumptions);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VMileageConsumption vMileageConsumption) {
        if(this.ivMileageConsumptionService.updateById(vMileageConsumption)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VMileageConsumption vMileageConsumption) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivMileageConsumptionService.list(new QueryWrapper<VMileageConsumption>().setEntity(vMileageConsumption)));
    }

}

