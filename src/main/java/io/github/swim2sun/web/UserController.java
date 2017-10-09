package io.github.swim2sun.web;

import io.github.swim2sun.domain.User;
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
