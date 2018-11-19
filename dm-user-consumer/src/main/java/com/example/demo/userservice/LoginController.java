package com.example.demo.userservice;

import com.springCloud.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserFeignClient userFeignClient;

    @PostMapping("/userlogin")
    public String login(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {

        String str = "";
        for (int i = 0; i < 10; i++) {
            str += String.format("%s\r\n", userFeignClient.login(i));
        }

        return str;
    }
}
