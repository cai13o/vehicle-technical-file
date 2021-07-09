package cn.com.zz.controller;


import cn.com.zz.annotation.IgnoreAuth;
import cn.com.zz.entity.TUser;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.ITUserService;
import cn.com.zz.util.JwtUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 13o
 * @since 2021-07-08
 */
@Api(tags = "用户")
@Slf4j
@RestController
@RequestMapping("/tuser")
public class TUserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ITUserService userService;

    @IgnoreAuth
    @PostMapping("/login")
    @ApiOperation(value = "后台用户登录")
    public Result userLogin(@RequestBody TUser user) {
        String username = user.getMobile();
        log.info(username, "帐号不能为空");
        String password = user.getPassword();
        log.info(password, "密码不能为空");
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(md5Password);
        List<TUser> byAll = this.userService.list(new QueryWrapper<TUser>().setEntity(user));
        if(byAll.size()!=0) {
            TUser tUser = byAll.get(0);
            Map<String, Object> map = new HashMap<>(3);
            if (tUser == null) {
                return Result.error(ResultCodeEnum.ERROR_NOT_EXISTS_USER);
            }

            String token = jwtUtil.generateToken(tUser.getMobile());


            map.put("token", token);
            map.put("tUser", tUser);
            map.put("expire", jwtUtil.getExpire());
            return Result.ok(ResultCodeEnum.SUCCESS, map);
        }
        return Result.error(ResultCodeEnum.ERROR_NOT_EXISTS_USER);
    }

    @GetMapping("/loginOut")
    @ApiOperation(value = "登录退出")
    public Result loginOut(String id) {
        return Result.ok(ResultCodeEnum.SUCCESS_LOGINOUT);
    }


}

