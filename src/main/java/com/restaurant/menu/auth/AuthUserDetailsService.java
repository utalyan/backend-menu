package com.restaurant.menu.auth;

import com.restaurant.menu.entity.User;
import com.restaurant.menu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.findUserByusername(s);

        if (user == null)
        {
            throw new UsernameNotFoundException("user not found");
        }

        AuthUserDetails authUserDetails = new AuthUserDetails(user);
        return authUserDetails;
    }
}
