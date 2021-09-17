package com.restaurant.menu.entity.vm;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@Immutable
@Table(name = "V_FOOD")
public class FoodVM {
    @Id
    private Long id;

    @NotEmpty
    private String name;

    @Digits(integer = 7,fraction = 2)
    @NotNull
    private BigDecimal servingGram;

    @Digits(integer = 7, fraction = 2)
    @NotNull
    private BigDecimal price;

    private String description;
    @NotEmpty
    private String image;

    @NotNull
    private Long typeOfId;
    private String typeOfName;
}
