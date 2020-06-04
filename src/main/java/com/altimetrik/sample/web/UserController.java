package com.altimetrik.sample.web;

import com.altimetrik.sample.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @RequestMapping("hello")
    public String find() {
        return "Altimetrik new Lassa";
    }

}
