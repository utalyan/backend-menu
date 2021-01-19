package com.restaurant.menu.controller;

import com.restaurant.menu.service.VMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VMController {

    @Autowired
    VMService vmService;

    @GetMapping("/api/1.0/city")
    public ResponseEntity<?> getCity()
    {
        return ResponseEntity.ok(vmService.getCityList());
    }

    @GetMapping("/api/1.0/countys/{cityId}")
    public  ResponseEntity<?> getCountyByCity(@PathVariable(required = true) Long cityId)
    {
        return ResponseEntity.ok(vmService.getCountyByCityId(cityId));
    }
}
