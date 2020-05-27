package com.practice.jwtredisstudy.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.practice.jwtredisstudy.annotation.PassToken;
import com.practice.jwtredisstudy.domain.User;
import com.practice.jwtredisstudy.mapper.UserMapper;
import com.practice.jwtredisstudy.service.TokenService;
import com.practice.jwtredisstudy.utils.ConstantUtils;
import com.practice.jwtredisstudy.utils.ResponseTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author yangguang.hu
 * @create 2020-05-22 14:25
 */
@Api(value = "用户相关接口")
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userInfo", value = "用户信息")
    })
    public ResponseTemplate login(@RequestBody JSONObject userInfo) {
        String username = userInfo.getString("username");
        String password = userInfo.getString("password");
        List<User> users = userMapper.selectList(new EntityWrapper()
                .eq("username", username)
                .eq("password", password));
        User user = users.get(0);
        JSONObject result = new JSONObject();
        if (user != null) {
            Jedis jedis =new Jedis("localhost", 6379);
            String token = tokenService.getToken(user);
            jedis.set(username, token);
            jedis.expire(username, ConstantUtils.TOKEN_EXPIRE_TIME);
            jedis.set(token, username);
            jedis.expire(token, ConstantUtils.TOKEN_EXPIRE_TIME);
            Long currentTime = System.currentTimeMillis();
            jedis.set(token + username, currentTime.toString());
            jedis.close();
            result.put("status", "登陆成功！");
            result.put("token", token);
        } else {
            result.put("status", "登录失败！");
        }
        return  ResponseTemplate.ok("200", "登陆成功！", result);
        /*return ResponseTemplate.builder()
                .code(200)
                .message("登陆成功！")
                .data(result)
                .build();*/

    }

    @ApiOperation("测试token接口")
    @GetMapping("/test")
    @PassToken
    public ResponseTemplate tokenTest() {
        List<User> users = new User().selectAll();
        return ResponseTemplate.ok("200", "登录成功！", users);
    }
}
