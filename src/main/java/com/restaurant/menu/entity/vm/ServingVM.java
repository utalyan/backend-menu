package com.restaurant.menu.entity.vm;

import com.restaurant.menu.entity.Serving;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "V_SERVING")
@Immutable
public class ServingVM {
    @Id
    private Long id;
    private String name;
    private BigDecimal factor;
    private Long typeOfId;
    private String nameTypeOf;
    private Long firmId;

    public ServingVM() {
    }

    public ServingVM(Serving serving) {
        this.id = serving.getId();
        this.name = serving.getName();
        this.factor = serving.getFactor();
        this.typeOfId = serving.getTypeOfId();
        this.nameTypeOf = serving.getTypeOf().getName();
    }
}
