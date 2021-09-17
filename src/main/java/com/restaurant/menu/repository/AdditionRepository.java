package com.restaurant.menu.repository;

import com.restaurant.menu.entity.Addition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdditionRepository extends JpaRepository<Addition,Long> {
    List<Addition> findByFirmId(Long id);
}
