package com.example.security.controller;

import com.alibaba.fastjson.JSON;
import com.example.security.entity.SysUser;
import com.example.security.service.SysUserService;
import com.example.security.utils.RedisCache;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Puyb
 * @date ：Created in 2022/8/16 14:22
 * @description：
 */
@RestController
@RequestMapping("/home")
public class ControllerTest {
    @Resource
    RedisCache redisCache;
    @Resource
    RedisTemplate redisTemplate;
    @Resource
    SysUserService sysUserService;
        @GetMapping("/test")
        @ApiOperation(value = "一个测试API", notes = "第一个测试api")
        public List<SysUser> test(){
//            String test = (String) redisCache.getCacheObject("test");
            String test1 = String.valueOf(redisTemplate.opsForValue().get("test"));
            String s = JSON.parseObject(test1, String.class);
            List<SysUser> list = sysUserService.list();
            return list;
        }
}
