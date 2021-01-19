package com.restaurant.menu.auth;


import com.restaurant.menu.entity.vm.UserVM;
import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private UserVM userVM;
    private String logo;
}
