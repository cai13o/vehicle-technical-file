package cn.com.zz.controller;


import cn.com.zz.entity.VAnnualInspection;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVAnnualInspectionService;
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
 * 车辆年度审验登记表 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "车辆年度审验登记表")
@RestController
@RequestMapping("/vannualinspection")
public class VAnnualInspectionController {

    @Resource
    private IVAnnualInspectionService ivAnnualInspectionService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VAnnualInspection vAnnualInspection) {
        if(this.ivAnnualInspectionService.save(vAnnualInspection)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VAnnualInspection vAnnualInspection = this.ivAnnualInspectionService.getById(id);
        if(null != vAnnualInspection){
            return Result.ok(ResultCodeEnum.SUCCESS,vAnnualInspection);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VAnnualInspection> vAnnualInspections = this.ivAnnualInspectionService.list(new QueryWrapper<VAnnualInspection>().eq("vin",vin));
        if(0 != vAnnualInspections.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vAnnualInspections);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VAnnualInspection vAnnualInspection) {
        if(this.ivAnnualInspectionService.updateById(vAnnualInspection)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VAnnualInspection vAnnualInspection) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivAnnualInspectionService.list(new QueryWrapper<VAnnualInspection>().setEntity(vAnnualInspection)));
    }
}

