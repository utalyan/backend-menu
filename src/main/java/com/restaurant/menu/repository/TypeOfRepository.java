package com.restaurant.menu.repository;

import com.restaurant.menu.entity.TypeOf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeOfRepository extends JpaRepository<TypeOf,Long> {

    List<TypeOf> findByFirmId(Long id);

    void deleteByIdAndFirmId(Long id, Long id1);
}
