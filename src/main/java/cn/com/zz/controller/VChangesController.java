package cn.com.zz.controller;


import cn.com.zz.entity.VChanges;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVChangesService;
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
 * 车辆变更记录表 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "车辆变更记录表")
@RestController
@RequestMapping("/vchanges")
public class VChangesController {

    @Resource
    private IVChangesService ivChangesService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VChanges vChanges) {
        if(this.ivChangesService.save(vChanges)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VChanges vChanges = this.ivChangesService.getById(id);
        if(null != vChanges){
            return Result.ok(ResultCodeEnum.SUCCESS,vChanges);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据vin获取数据")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOne(String vin) {
        List<VChanges> vChangess = this.ivChangesService.list(new QueryWrapper<VChanges>().eq("vin",vin));
        if(0 != vChangess.size()){
            return Result.ok(ResultCodeEnum.SUCCESS,vChangess);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VChanges vChanges) {
        if(this.ivChangesService.updateById(vChanges)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VChanges vChanges) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivChangesService.list(new QueryWrapper<VChanges>().setEntity(vChanges)));
    }
}

