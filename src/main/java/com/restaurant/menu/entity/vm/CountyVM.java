package com.restaurant.menu.entity.vm;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "V_COUNTY")
@Data
public class CountyVM {

    @Id
    private Long id;
    private  String name;

    private Long cityId;
}
