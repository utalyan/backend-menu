package com.restaurant.menu.entity.vm;

import com.restaurant.menu.entity.Addition;
import com.restaurant.menu.entity.Firm;
import com.restaurant.menu.entity.TypeOf;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name="V_ADDITION")
@Entity
@Immutable
public class AdditionVM {
    @Id
    private Long id;

    private String name;

    private BigDecimal amount;

    private Long typeOfId;

    private String typeOfName;

    private Long firmId;

    public  AdditionVM(){};

    public AdditionVM(Addition addition) {
        this.id = addition.getId();
        this.name = addition.getName();
        this.amount = addition.getAmount();
        this.typeOfId = addition.getTypeOf().getId();
        this.typeOfName = addition.getTypeOf().getName();
        this.firmId = addition.getFirm().getId();
    }
}
