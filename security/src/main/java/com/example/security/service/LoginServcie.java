package com.example.security.service;

import com.example.security.entity.User;
import com.example.security.resultVO.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * @author ：Puyb
 * @date ：Created in 2022/9/29 16:32
 * @description：
 */
@Service
public interface LoginServcie {
    ResponseResult login(User user);
}
