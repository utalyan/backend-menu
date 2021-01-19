package com.restaurant.menu.auth;

import com.restaurant.menu.entity.User;
import com.restaurant.menu.entity.vm.UserVM;
import com.restaurant.menu.service.UserService;
import io.jsonwebtoken.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    UserService userService;

    PasswordEncoder passwordEncoder;

    AuthUserDetailsService authUserDetailsService;

    public AuthService(UserService userService,PasswordEncoder passwordEncoder,AuthUserDetailsService authUserDetailsService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authUserDetailsService = authUserDetailsService;
    }

    public AuthResponse authenticate(Credentials credentials) {

        User user;

        try {
            user = userService.findUserByusername(credentials.getUsername());
        }catch (Exception e){
            throw new AuthException();
        }


        boolean matches = passwordEncoder.matches(credentials.getPassword(),user.getPassword());

        if (!matches){
            throw new AuthException();
        }

        UserVM userVM = new UserVM(user);

        Map<String,Object>  stringObjectMap = new HashMap<>();

        stringObjectMap.put("test",userVM);

        Date expiresAt = new Date(System.currentTimeMillis() + 3 * 60 * 60 * 1000);

        String token = Jwts.builder().setSubject("" + user.getId())
                .signWith(SignatureAlgorithm.HS512,"1071Kaz@nmaK1453")
                .setExpiration(expiresAt)
                .compact();

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setUserVM(userVM);

        return authResponse;
    }

    public AuthUserDetails getUserDetails(String token) {
        JwtParser jwtParser = Jwts.parser().setSigningKey("1071Kaz@nmaK1453");

        try {

            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            Long userId = Long.valueOf(claims.getSubject());

            User user = userService.findById(userId);
            AuthUserDetails authUserDetails = new AuthUserDetails(user);
            return authUserDetails;
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to get JWT Token");
        }
        catch (SignatureException e){
            System.out.println("JWT signature does not match locally computed signature");
        }catch (ExpiredJwtException e) {
            System.out.println("JWT Token has expired");
        }
         catch (Exception e){
          e.printStackTrace();
        }


        return null;

    }
}
