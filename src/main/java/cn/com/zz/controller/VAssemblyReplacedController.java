package cn.com.zz.controller;


import cn.com.zz.entity.VAssemblyReplaced;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVAssemblyReplacedService;
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
 * 车辆主要总成部件更换登记表 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "车辆主要总成部件更换登记表")
@RestController
@RequestMapping("/vassemblyreplaced")
public class VAssemblyReplacedController {
    
    @Resource
    private IVAssemblyReplacedService ivAssemblyReplacedService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VAssemblyReplaced vAssemblyReplaced) {
        if (this.ivAssemblyReplacedService.save(vAssemblyReplaced)) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VAssemblyReplaced vAssemblyReplaced = this.ivAssemblyReplacedService.getById(id);
        if (null != vAssemblyReplaced) {
            return Result.ok(ResultCodeEnum.SUCCESS, vAssemblyReplaced);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VAssemblyReplaced> vAssemblyReplaceds = this.ivAssemblyReplacedService.list(new QueryWrapper<VAssemblyReplaced>().eq("vin",vin));
        if(0 != vAssemblyReplaceds.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vAssemblyReplaceds);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VAssemblyReplaced vAssemblyReplaced) {
        if (this.ivAssemblyReplacedService.updateById(vAssemblyReplaced)) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VAssemblyReplaced vAssemblyReplaced) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivAssemblyReplacedService.list(new QueryWrapper<VAssemblyReplaced>().setEntity(vAssemblyReplaced)));
    }
}

