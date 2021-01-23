package com.restaurant.menu.entity.vm;

import com.restaurant.menu.entity.Serving;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServingVM {
    private Long id;
    private String name;
    private BigDecimal factor;
    private String nameTypeOf;

    public ServingVM() {
    }

    public ServingVM(Serving serving) {
        this.id = serving.getId();
        this.name = serving.getName();
        this.factor = serving.getFactor();
        this.nameTypeOf = serving.getTypeOf().getName();
    }
}
