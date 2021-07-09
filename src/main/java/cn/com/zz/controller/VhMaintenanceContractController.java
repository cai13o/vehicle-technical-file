package cn.com.zz.controller;


import cn.com.zz.entity.VhMaintenanceContract;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVhMaintenanceContractService;
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
 * 机动车维修合同 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "机动车维修合同")
@RestController
@RequestMapping("/vhmaintenancecontract")
public class VhMaintenanceContractController {

    @Resource
    private IVhMaintenanceContractService ivhMaintenanceContractService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VhMaintenanceContract vhMaintenanceContract) {
        if(this.ivhMaintenanceContractService.save(vhMaintenanceContract)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VhMaintenanceContract vhMaintenanceContract = this.ivhMaintenanceContractService.getById(id);
        if(null != vhMaintenanceContract){
            return Result.ok(ResultCodeEnum.SUCCESS,vhMaintenanceContract);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VhMaintenanceContract> vhMaintenanceContracts = this.ivhMaintenanceContractService.list(new QueryWrapper<VhMaintenanceContract>().eq("vin",vin));
        if(0 != vhMaintenanceContracts.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vhMaintenanceContracts);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VhMaintenanceContract vhMaintenanceContract) {
        if(this.ivhMaintenanceContractService.updateById(vhMaintenanceContract)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VhMaintenanceContract vhMaintenanceContract) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivhMaintenanceContractService.list(new QueryWrapper<VhMaintenanceContract>().setEntity(vhMaintenanceContract)));
    }
}

