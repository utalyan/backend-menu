package com.restaurant.menu.controller;

import com.restaurant.menu.entity.User;
import com.restaurant.menu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/api/1.0/users")
    public ResponseEntity<?> userCreate(@Valid @RequestBody User user)
    {
        userService.create(user);

        return ResponseEntity.ok("USER created");
    }
}
