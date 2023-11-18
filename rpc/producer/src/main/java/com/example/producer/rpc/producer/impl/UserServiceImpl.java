package com.example.producer.rpc.producer.impl;

import com.example.producer.rpc.producer.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public String findById() {
        return "user{id=1,username=dalao}";
    }
}
