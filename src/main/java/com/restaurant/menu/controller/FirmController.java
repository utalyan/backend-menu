package com.restaurant.menu.controller;

import com.restaurant.menu.auth.AuthUserDetails;
import com.restaurant.menu.entity.Firm;
import com.restaurant.menu.entity.User;
import com.restaurant.menu.entity.vm.RepastVM;
import com.restaurant.menu.service.FirmService;
import com.restaurant.menu.service.RepastService;
import com.restaurant.menu.service.UserService;
import com.restaurant.menu.shared.UniqueUsernameValidator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.ForkJoinPool;

@RestController
public class FirmController {

    @Autowired
    FirmService firmService;

    @Autowired
    RepastService repastService;

    @Autowired
    UserService userService;

    public static final Logger log = LoggerFactory.getLogger(FirmController.class);

    @PostMapping(path = "/api/1.0/firms")
    ResponseEntity<?> createFirm(@Valid @RequestBody Firm firm)
    {
        firmService.create(firm);

        return ResponseEntity.ok("FIRM created");
    }

    @GetMapping(path = "/api/1.0/repasts")
    ResponseEntity<?> getAllrepast(@RequestHeader("Authorization") String token){

        AuthUserDetails authUserDetails = (AuthUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userService.findById(authUserDetails.getUserId());

        return ResponseEntity.ok(repastService.getAllRepastWithFirm(user.getFirm().getId()));
    }

    @PostMapping(path = "/api/1.0/repasts")
    public ResponseEntity<?> createRepast(@RequestBody RepastVM repastVM)
    {
        AuthUserDetails authUserDetails = (AuthUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userService.findById(authUserDetails.getUserId());

        repastVM.setFirm(user.getFirm());

        return  ResponseEntity.ok(repastService.save(repastVM));
    }
}
