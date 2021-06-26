package com.example.service;

import com.example.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @program: springbooot-practice
 * @description:
 * @author: xrwang8
 * @create: 2021-06-26 11:22
 **/
@Service
public class UserService {

    public User getUser(User user) {
        return user;
    }
}
