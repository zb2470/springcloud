package com.springcloud.demo.userservice;

import com.springCloud.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @PostMapping("/login")
    public String login(@RequestParam("count") Integer count) {
        logger.info("access 2 8080");
        return "success 2" + count;
    }
}
