package com.restaurant.menu.entity.vm;

import com.restaurant.menu.entity.Firm;
import lombok.Data;

import javax.persistence.Column;

@Data
public class RepastVM {
    private Long id;
    private String name;
    private Firm firm;
}
