package com.altimetrik.sample.web;

import com.altimetrik.sample.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/find")
    public User find() {
        return new User("Milo","foobar@gmail.com");
    }

}
