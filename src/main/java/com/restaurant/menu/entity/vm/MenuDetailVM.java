package com.restaurant.menu.entity.vm;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Immutable
@Data
@Table(name = "V_MENU_DETAIL")
public class MenuDetailVM {
    @Id
    private Long id;
    private Long menuId;
    private Long typeOfId;
    private String typeOfName;
    private Long food_id;
    private String foodName;
    private BigDecimal foodPrice;
}
