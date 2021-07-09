package cn.com.zz.controller;


import cn.com.zz.entity.VhMaintenanceCompletion;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVhMaintenanceCompletionService;
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
 * 机动车维修竣工出厂合格证 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "机动车维修竣工出厂合格证")
@RestController
@RequestMapping("/vhmaintenancecompletion")
public class VhMaintenanceCompletionController {

    @Resource
    private IVhMaintenanceCompletionService ivhMaintenanceCompletionService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VhMaintenanceCompletion vhMaintenanceCompletion) {
        if(this.ivhMaintenanceCompletionService.save(vhMaintenanceCompletion)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VhMaintenanceCompletion vhMaintenanceCompletion = this.ivhMaintenanceCompletionService.getById(id);
        if(null != vhMaintenanceCompletion){
            return Result.ok(ResultCodeEnum.SUCCESS,vhMaintenanceCompletion);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VhMaintenanceCompletion> vhMaintenanceCompletions = this.ivhMaintenanceCompletionService.list(new QueryWrapper<VhMaintenanceCompletion>().eq("vin",vin));
        if(0 != vhMaintenanceCompletions.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vhMaintenanceCompletions);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }
    
    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VhMaintenanceCompletion vhMaintenanceCompletion) {
        if(this.ivhMaintenanceCompletionService.updateById(vhMaintenanceCompletion)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VhMaintenanceCompletion vhMaintenanceCompletion) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivhMaintenanceCompletionService.list(new QueryWrapper<VhMaintenanceCompletion>().setEntity(vhMaintenanceCompletion)));
    }
}

