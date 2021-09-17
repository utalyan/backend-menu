package com.restaurant.menu.entity;

import com.restaurant.menu.entity.vm.FoodVM;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Data
public class Food {
    @Id
    @SequenceGenerator(name = "seq",sequenceName = "food_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    private Long id;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String name;

    @Digits(integer = 7,fraction = 2)
    @Column(precision = 7, scale = 2)
    private BigDecimal servingGram;

    @Digits(integer = 7, fraction = 2)
    @Column(precision = 7, scale = 2)
    private BigDecimal price;

    @Column(length = 200)
    private String description;

    @Column(length = 50)
    private String image;

    @ManyToOne
    private TypeOf typeOf;

    @ManyToOne
    private Firm firm;

}
