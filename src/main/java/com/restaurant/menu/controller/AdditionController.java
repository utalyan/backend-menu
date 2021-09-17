package com.restaurant.menu.controller;

import com.restaurant.menu.auth.AuthUserDetails;
import com.restaurant.menu.entity.Addition;
import com.restaurant.menu.entity.User;
import com.restaurant.menu.entity.vm.AdditionVM;
import com.restaurant.menu.service.AdditionService;
import com.restaurant.menu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AdditionController {

    @Autowired
    AdditionService additionService;

    @Autowired
    UserService userService;

    @GetMapping(path = "/api/1.0/additions/{id}")
    public ResponseEntity<?> getAllAddition(@PathVariable("id") Long typeOfId){
        AuthUserDetails authUserDetails =  (AuthUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userService.findById(authUserDetails.getUserId());

        return ResponseEntity.ok(additionService.findByFirmId(user.getFirm().getId(),typeOfId));

    }

    @PostMapping(path = "/api/1.0/additions")
    public AdditionVM saveAddition(@Valid @RequestBody Addition addition)
    {
        Addition addition1 = additionService.save(addition);

        AdditionVM additionVM = new AdditionVM(addition1);
        return additionVM;
    }

    @DeleteMapping(path = "/api/1.0/additions/{id}")
    public void deleteAddition(@PathVariable Long id){
        additionService.deleteById(id);
    }
}
