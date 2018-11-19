package com.example.demo.userservice;

import com.example.demo.userservice.impl.UserFeignClientFallback;
import com.springCloud.demo.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "dm-user-provider", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @PostMapping("/login")
    String login(@RequestParam("count") Integer count);
}
