package com.restaurant.menu.controller;

import com.restaurant.menu.auth.AuthUserDetails;
import com.restaurant.menu.entity.Serving;
import com.restaurant.menu.entity.TypeOf;
import com.restaurant.menu.entity.User;
import com.restaurant.menu.entity.vm.ServingVM;
import com.restaurant.menu.service.ServingService;
import com.restaurant.menu.service.TypeOfService;
import com.restaurant.menu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ServingController {


    UserService userService;
    ServingService servingService;
    TypeOfService typeOfService;

    public ServingController(UserService userService, ServingService servingService, TypeOfService typeOfService) {
        this.userService = userService;
        this.servingService = servingService;
        this.typeOfService = typeOfService;
    }

    @GetMapping(path = "/api/1.0/serving")
    public ResponseEntity<?> getAllServing()
    {
        AuthUserDetails authUserDetails = (AuthUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userService.findById(authUserDetails.getUserId());

        return ResponseEntity.ok(servingService.getAllServing(user));

    }

    @PostMapping(path = "/api/1.0/serving")
    public ServingVM saveServing(@Valid @RequestBody Serving serving)
    {
        TypeOf typeOf =  typeOfService.findById(serving.getTypeOfId());

        serving.setTypeOf(typeOf);

        servingService.save(serving);

        ServingVM servingVM = new ServingVM(serving);

        return  servingVM;
    }

    @DeleteMapping(path = "/api/1.0/serving/{id}")
    public void deleteServing(@PathVariable Long id)
    {
        servingService.deleteById(id);
    }
}
