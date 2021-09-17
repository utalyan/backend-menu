package com.restaurant.menu.entity.vm;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Immutable
@Table(name = "V_FOOD_SHORT")
public class FoodShortVM {
    @Id
    private Long id;

    private String name;
}
