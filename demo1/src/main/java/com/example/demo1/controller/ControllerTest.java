package com.example.demo1.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ：Puyb
 * @date ：Created in 2021/12/13 16:27
 * @description：
 */
@Api(value = "swagger", tags = "swagger")
@RestController
public class ControllerTest {

    @ApiOperation("test")
    @PostMapping("/test")

    public String hello(@RequestBody Map<String, Object> params) {
        final String startTime = (String) params.get("startTime");
        return String.valueOf(params.get("startTime"));
    }

    @ApiOperation("test1")
    @PostMapping("/test1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "time", value = "一级设施id", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "rightLatitude", value = "地图右上纬度", dataType = "decimal")
    })
    public String hello1(@RequestBody Map<String, String> params) {
        System.out.println(String.valueOf(params.get("time")));
        return String.valueOf(params.get("time"));
    }
}
