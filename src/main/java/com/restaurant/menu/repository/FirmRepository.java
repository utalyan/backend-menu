package com.restaurant.menu.repository;

import com.restaurant.menu.entity.Firm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FirmRepository extends JpaRepository<Firm,Long> {
    Optional<Firm> findByName(String username);

    Optional<Firm> findByEmail(String value);
}
