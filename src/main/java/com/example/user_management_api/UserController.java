package com.example.user_management_api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from Spring Boot!";
    }
}
