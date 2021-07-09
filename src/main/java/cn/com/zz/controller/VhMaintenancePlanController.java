package cn.com.zz.controller;


import cn.com.zz.entity.VhMaintenancePlan;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVhMaintenancePlanService;
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
 * 维护计划 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "维护计划")
@RestController
@RequestMapping("/vhmaintenanceplan")
public class VhMaintenancePlanController {

    @Resource
    private IVhMaintenancePlanService ivhMaintenancePlanService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VhMaintenancePlan vhMaintenancePlan) {
        if(this.ivhMaintenancePlanService.save(vhMaintenancePlan)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VhMaintenancePlan vhMaintenancePlan = this.ivhMaintenancePlanService.getById(id);
        if(null != vhMaintenancePlan){
            return Result.ok(ResultCodeEnum.SUCCESS,vhMaintenancePlan);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VhMaintenancePlan> vhMaintenancePlans = this.ivhMaintenancePlanService.list(new QueryWrapper<VhMaintenancePlan>().eq("vin",vin));
        if(0 != vhMaintenancePlans.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vhMaintenancePlans);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VhMaintenancePlan vhMaintenancePlan) {
        if(this.ivhMaintenancePlanService.updateById(vhMaintenancePlan)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VhMaintenancePlan vhMaintenancePlan) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivhMaintenancePlanService.list(new QueryWrapper<VhMaintenancePlan>().setEntity(vhMaintenancePlan)));
    }
}

