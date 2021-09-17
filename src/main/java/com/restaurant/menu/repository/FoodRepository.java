package com.restaurant.menu.repository;

import com.restaurant.menu.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {
    List<Food> findByFirmIdAndTypeOfId(Long firmId, Long typeOfId);

    void deleteByIdAndFirmId(Long foodId, Long firmId);
}
