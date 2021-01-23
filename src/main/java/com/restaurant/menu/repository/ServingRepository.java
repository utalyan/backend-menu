package com.restaurant.menu.repository;

import com.restaurant.menu.entity.Serving;
import com.restaurant.menu.entity.vm.ServingVM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServingRepository extends JpaRepository<Serving,Long> {

    @Query(value = "SELECT  srv.id as id," +
            "               srv.name as name," +
            "               srv.factor as factor," +
            "               to.name as name_type_of " +
            "          FROM serving srv " +
            "           JOIN type_of to ON srv.type_of_id = to.id " +
            "           WHERE firm_id = ?1",nativeQuery = true)
    List<ServingVM> findAllServing(Long firmId);

    void deleteByIdAndFirmId(Long userId, Long firmId);
}
