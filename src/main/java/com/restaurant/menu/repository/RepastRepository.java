package com.restaurant.menu.repository;

import com.restaurant.menu.entity.Firm;
import com.restaurant.menu.entity.Repast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepastRepository extends JpaRepository<Repast,Long> {

    List<Repast> findByFirmId(Long firmId);

    void deleteByIdAndFirm(Long id, Firm firm);
}
