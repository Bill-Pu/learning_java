package com.example.security.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Puyb
 * @date ：Created in 2022/8/16 14:22
 * @description：
 */
@RestController
@RequestMapping("/home")
public class ControllerTest {
        @GetMapping("/test")
        @ApiOperation(value = "一个测试API", notes = "第一个测试api")

        public String test(){
            return "success";
        }
}
