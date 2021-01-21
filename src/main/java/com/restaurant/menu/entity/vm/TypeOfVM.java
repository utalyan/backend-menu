package com.restaurant.menu.entity.vm;

import com.restaurant.menu.entity.Firm;
import lombok.Data;

@Data
public class TypeOfVM {
    private Long id;
    private String name;
    private Firm firm;
}
