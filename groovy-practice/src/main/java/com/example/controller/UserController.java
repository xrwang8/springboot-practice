package com.example.controller;

import com.example.annotation.GroovyTest;
import com.example.pojo.User;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: springbooot-practice
 * @description:
 * @author: xrwang8
 * @create: 2021-06-26 11:23
 **/
@Api("用户信息管理")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation("获取用户信息")
    @PostMapping("/getUser")
    @GroovyTest
    public User getUser(@RequestBody User user) {
        User user1 = userService.getUser(user);
        log.info("请求结果为:{}", user1.toString());
        return user1;
    }
}
