package com.restaurant.menu.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name = "seq",sequenceName = "address_seq")
    private Long id;

    @NotNull
    @Column(length = 10)
    private Long cityId;

    @NotNull
    @Column(length = 10)
    private Long countyId;

    @Column(length = 255)
    private String adress;

    @ManyToOne
    User user;
}
