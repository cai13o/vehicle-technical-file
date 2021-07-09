package cn.com.zz.controller;


import cn.com.zz.entity.VAccident;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVAccidentService;
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
 * 车辆交通事故登记表 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "车辆交通事故登记表")
@RestController
@RequestMapping("/vaccident")
public class VAccidentController {

    @Resource
    private IVAccidentService ivAccidentService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VAccident vAccident) {
        if(this.ivAccidentService.save(vAccident)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VAccident vAccident = this.ivAccidentService.getById(id);
        if(null != vAccident){
            return Result.ok(ResultCodeEnum.SUCCESS,vAccident);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VAccident> vAccidents = this.ivAccidentService.list(new QueryWrapper<VAccident>().eq("vin",vin));
        if(0 != vAccidents.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vAccidents);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VAccident vAccident) {
        if(this.ivAccidentService.updateById(vAccident)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VAccident vAccident) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivAccidentService.list(new QueryWrapper<VAccident>().setEntity(vAccident)));
    }
}

