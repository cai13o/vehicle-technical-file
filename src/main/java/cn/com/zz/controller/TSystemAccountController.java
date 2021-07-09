package cn.com.zz.controller;


import cn.com.zz.annotation.IgnoreAuth;
import cn.com.zz.entity.TSystemAccount;
import cn.com.zz.enums.ResultCodeEnum;
import cn.com.zz.result.Result;
import cn.com.zz.service.ITSystemAccountService;
import cn.com.zz.util.JwtUtil;
import com.alibaba.fastjson.JSONObject;
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
@Api(tags = "系统账号")
@Slf4j
@RestController
@RequestMapping("/tsystemaccount")
public class TSystemAccountController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ITSystemAccountService systemAccountService;

    @IgnoreAuth
    @PostMapping("login")
    @ApiOperation(value = "后台系统账号登录", notes = "根据账号密码登录")
    public Object login(@RequestBody TSystemAccount systemAccount) {
        JSONObject jsonObject = new JSONObject();
        String loginid = systemAccount.getLoginid();
        if(loginid == null || ("").equals(loginid)){
            log.info(loginid, "帐号不能为空");
            jsonObject.put("message", "帐号不能为空");
            return jsonObject;
        }
        String password = systemAccount.getPassword();
        if(password == null || ("").equals(password)){
            log.info(password, "密码不能为空");
            jsonObject.put("message", "密码不能为空");
            return jsonObject;
        }
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        systemAccount.setPassword(md5Password);
        List<TSystemAccount> byAll = this.systemAccountService.list(new QueryWrapper<TSystemAccount>().setEntity(systemAccount));
        if(byAll.size()!=0) {
            TSystemAccount tSystemAccount = byAll.get(0);
            Map<String, Object> map = new HashMap<>(3);
            if (tSystemAccount == null) {
                return Result.error(ResultCodeEnum.ERROR_NOT_EXISTS_USER);
            } else if (!tSystemAccount.getLoginid().equals("admin")) {
                if (tSystemAccount.getStatus().equals("1")) {
                    return Result.error(ResultCodeEnum.ERROR_NO_STATUS);
                }
            }

            String token = jwtUtil.generateToken(systemAccount.getLoginid());

            map.put("token", token);
            map.put("systemAccount", tSystemAccount);
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

