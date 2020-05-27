package com.practice.jwtredisstudy.controller;

import com.practice.jwtredisstudy.annotation.PassToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "hello接口")
@RestController
public class HelloController {

    @PassToken
    @ApiOperation("say hello")
    @GetMapping("/hello")
    public String hello() {
        return "hello word!";
    }
}
