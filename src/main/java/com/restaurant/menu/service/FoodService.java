package com.restaurant.menu.service;

import com.restaurant.menu.entity.Food;
import com.restaurant.menu.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;

    public List<Food> getAllByTypeOfId(Long firmId, Long typeOfId) {
        List<Food> foods = foodRepository.findByFirmIdAndTypeOfId(firmId,typeOfId);

        return  foods;
    }

    public Food getById(Long id) {
        return foodRepository.findById(id).get();
    }

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public void delete(Long foodId, Long firmId) {
        foodRepository.deleteByIdAndFirmId(foodId,firmId);
    }
}
