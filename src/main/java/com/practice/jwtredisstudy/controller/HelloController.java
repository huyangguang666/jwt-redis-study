package com.practice.jwtredisstudy.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiModel("Hello")
@RestController
public class HelloController {

    @ApiOperation("hello接口")
    @GetMapping("/hello")
    public String hello() {
        return "hello word!";
    }
}
