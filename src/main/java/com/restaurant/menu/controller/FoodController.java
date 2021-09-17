package com.restaurant.menu.controller;

import com.restaurant.menu.auth.AuthUserDetails;
import com.restaurant.menu.entity.Food;
import com.restaurant.menu.entity.User;
import com.restaurant.menu.entity.vm.FoodVM;
import com.restaurant.menu.service.FoodService;
import com.restaurant.menu.service.TypeOfService;
import com.restaurant.menu.service.UserService;
import com.restaurant.menu.shared.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FoodController {

    FoodService foodService;

    UserService userService;

    FileService fileService;

    TypeOfService typeOfService;

    public FoodController(FoodService foodService, UserService userService, FileService fileService, TypeOfService typeOfService) {
        this.foodService = foodService;
        this.userService = userService;
        this.fileService = fileService;
        this.typeOfService = typeOfService;
    }

    @GetMapping(path = "/api/1.0/foods/{id}")
    public ResponseEntity<?> getAllFood(@PathVariable("id") Long typeOfId){
        AuthUserDetails authUserDetails =  (AuthUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findById(authUserDetails.getUserId());

        List<Food> foods = foodService.getAllByTypeOfId(user.getFirm().getId(), typeOfId);

        List<FoodVM> foodVMS = foods.stream().map(food ->{
            FoodVM foodVM = new FoodVM();
            foodVM.setId(food.getId());
            foodVM.setName(food.getName());


            foodVM.setImage("images/" + food.getFirm().getId() + "/" + food.getImage());
            foodVM.setDescription(food.getDescription());
            foodVM.setPrice(food.getPrice());
            foodVM.setServingGram(food.getServingGram());
            foodVM.setTypeOfId(food.getTypeOf().getId());
            foodVM.setTypeOfName(food.getTypeOf().getName());
            return foodVM;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(foodVMS);
    }

    @PostMapping(path = "/api/1.0/foods")
    public FoodVM saveFood(@Valid @RequestBody FoodVM foodVM){

        AuthUserDetails authUserDetails =  (AuthUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findById(authUserDetails.getUserId());

        String imageName = null;

        Food food = null;

        if (foodVM.getId() != null){
            food = foodService.getById(foodVM.getId());
        }else {
            food = new Food();
            food.setFirm(user.getFirm());
            food.setTypeOf(typeOfService.findById(foodVM.getTypeOfId()));
        }

        food.setName(foodVM.getName());
        food.setDescription(foodVM.getDescription());
        food.setPrice(foodVM.getPrice());
        food.setServingGram(foodVM.getServingGram());

        //|| !food.getImage().equals(foodVM.getImage())
        //image: picture-storage/1/file-name
        if (foodVM.getImage() != null) {

            if ( food.getImage()!=null ) {
                if (  (!foodVM.getImage().contains(food.getImage()))) {
                    fileService.deleteFile(food.getImage(), String.valueOf(user.getFirm().getId()));
                    imageName = fileService.convertAndWriteBase64ToFile(foodVM.getImage(), String.valueOf(user.getFirm().getId()));
                    food.setImage(imageName);
                }
            }else{
                fileService.deleteFile(food.getImage(), String.valueOf(user.getFirm().getId()));
                imageName = fileService.convertAndWriteBase64ToFile(foodVM.getImage(), String.valueOf(user.getFirm().getId()));
                food.setImage(imageName);
            }

        }

        Food food1 = foodService.save(food);
        foodVM.setId(food1.getId());
        foodVM.setImage(food1.getImage());
        return  foodVM;
    }

    @DeleteMapping(path = "/api/1.0/foods/{id}")
    public void deleteFood(@PathVariable("id") Long foodId){
        AuthUserDetails authUserDetails =  (AuthUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findById(authUserDetails.getUserId());

        Long firmId = user.getFirm().getId();

        Food food = foodService.getById(foodId);

        if(food.getImage() != null){
            fileService.deleteFile(food.getImage(),String.valueOf(firmId));
        }

        foodService.delete(foodId,firmId);
    }
}
