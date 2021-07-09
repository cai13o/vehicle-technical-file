package cn.com.zz.controller;


import cn.com.zz.entity.VBasicInformation;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVBasicInformationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
 * 车辆基本情况 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "车辆基本情况")
@RestController
@RequestMapping("/vbasicinformation")
public class VBasicInformationController {

    @Resource
    private IVBasicInformationService ivBasicInformationService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VBasicInformation vBasicInformation) {
        if(this.ivBasicInformationService.save(vBasicInformation)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VBasicInformation vBasicInformation = this.ivBasicInformationService.getById(id);
        if(null != vBasicInformation){
            return Result.ok(ResultCodeEnum.SUCCESS,vBasicInformation);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VBasicInformation> vBasicInformations = this.ivBasicInformationService.list(new QueryWrapper<VBasicInformation>().eq("vin",vin));
        if(0 != vBasicInformations.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vBasicInformations);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VBasicInformation vBasicInformation) {
        if(this.ivBasicInformationService.updateById(vBasicInformation)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VBasicInformation vBasicInformation) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivBasicInformationService.list(new QueryWrapper<VBasicInformation>().setEntity(vBasicInformation)));
    }


    @ApiOperation("分页查询")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Result page(String page,String limit,VBasicInformation vBasicInformation) {
        Integer intPage = Integer.parseInt(page);
        Integer intLimit = Integer.parseInt(limit);
        Page<VBasicInformation> basicInformationPage = new Page<>(intPage,intLimit);
        return Result.ok(ResultCodeEnum.SUCCESS ,
                this.ivBasicInformationService.page(basicInformationPage,new QueryWrapper<VBasicInformation>().setEntity(vBasicInformation)));
    }
}

