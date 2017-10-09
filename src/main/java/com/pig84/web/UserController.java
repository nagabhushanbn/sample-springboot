package com.pig84.web;

import com.pig84.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/find")
    public User find() {
        return new User("Milo","Milo.you@pig84.com");
    }

}
