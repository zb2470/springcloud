package com.example.demo.userservice.impl;

import com.example.demo.userservice.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public String login(Integer count) {
        return "xitongyichang" + count;
    }
}
