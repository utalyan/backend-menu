package com.restaurant.menu.auth;

import com.restaurant.menu.entity.vm.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping(path = "/api/1.0/auth")
    public AuthResponse authUser(@RequestBody Credentials credentials)
    {
        return authService.authenticate(credentials);

    }
}
