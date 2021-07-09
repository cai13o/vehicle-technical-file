package cn.com.zz.controller;


import cn.com.zz.entity.VsBusinessOwner;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.IVsBusinessOwnerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 经营业户 前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Api(tags = "经营业户")
@RestController
@RequestMapping("/vsbusinessowner")
public class VsBusinessOwnerController {

    @Resource
    private IVsBusinessOwnerService ivsBusinessOwnerService;


    @ApiOperation("新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody VsBusinessOwner vsBusinessOwner) {
        if(this.ivsBusinessOwnerService.save(vsBusinessOwner)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getById(String id) {
        VsBusinessOwner vsBusinessOwner = this.ivsBusinessOwnerService.getById(id);
        if(null != vsBusinessOwner){
            return Result.ok(ResultCodeEnum.SUCCESS,vsBusinessOwner);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }


    @ApiOperation("修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody VsBusinessOwner vsBusinessOwner) {
        if(this.ivsBusinessOwnerService.updateById(vsBusinessOwner)){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAll", method = RequestMethod.GET)
    public Result findByAll(VsBusinessOwner vsBusinessOwner) {
        return Result.ok(ResultCodeEnum.SUCCESS , this.ivsBusinessOwnerService.list(new QueryWrapper<VsBusinessOwner>().setEntity(vsBusinessOwner)));
    }
}

