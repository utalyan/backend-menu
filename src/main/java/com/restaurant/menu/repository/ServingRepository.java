package com.restaurant.menu.repository;

import com.restaurant.menu.entity.Serving;
import com.restaurant.menu.entity.vm.ServingVM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ServingRepository extends JpaRepository<Serving,Long> {

    void deleteByIdAndFirmId(Long userId, Long firmId);
}
