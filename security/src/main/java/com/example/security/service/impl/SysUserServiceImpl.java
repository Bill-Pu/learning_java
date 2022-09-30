package com.example.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.security.mapper.SysUserDao;
import com.example.security.entity.User;
import com.example.security.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2022-09-27 18:10:23
 */
@Service()
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, User> implements SysUserService {

}

