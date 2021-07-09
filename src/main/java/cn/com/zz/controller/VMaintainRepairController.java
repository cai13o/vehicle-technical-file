package cn.com.zz.controller;


import cn.com.zz.entity.VMaintainRepair;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVMaintainRepairService;
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
 * 车辆维护与维修登记表 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "车辆维护与维修登记表")
@RestController
@RequestMapping("/vmaintainrepair")
public class VMaintainRepairController {

    @Resource
    private IVMaintainRepairService ivMaintainRepairService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VMaintainRepair vMaintainRepair) {
        if(this.ivMaintainRepairService.save(vMaintainRepair)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VMaintainRepair vMaintainRepair = this.ivMaintainRepairService.getById(id);
        if(null != vMaintainRepair){
            return Result.ok(ResultCodeEnum.SUCCESS,vMaintainRepair);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VMaintainRepair> vMaintainRepairs = this.ivMaintainRepairService.list(new QueryWrapper<VMaintainRepair>().eq("vin",vin));
        if(0 != vMaintainRepairs.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vMaintainRepairs);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VMaintainRepair vMaintainRepair) {
        if(this.ivMaintainRepairService.updateById(vMaintainRepair)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VMaintainRepair vMaintainRepair) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivMaintainRepairService.list(new QueryWrapper<VMaintainRepair>().setEntity(vMaintainRepair)));
    }
}

