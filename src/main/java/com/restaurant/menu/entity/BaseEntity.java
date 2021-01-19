package com.restaurant.menu.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Date recordDate;

}
