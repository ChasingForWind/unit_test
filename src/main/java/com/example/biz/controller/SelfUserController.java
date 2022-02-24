package com.example.biz.controller;

import com.example.biz.dao.domain.SelfUserDetail;
import com.example.biz.service.SelfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhiyang
 * @description: 用户相关
 * @create: 2022-01-17 11:19
 **/

@RestController
@RequestMapping("/user")
public class SelfUserController {
    @Autowired
    SelfUserService selfUserService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/getUser")
    public SelfUserDetail getUser(){
        return selfUserService.getUserById(2);
    }
}
