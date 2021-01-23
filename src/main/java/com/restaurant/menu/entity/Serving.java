package com.restaurant.menu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
public class Serving {

    @Id
    @SequenceGenerator(name = "seq",sequenceName = "servingSeq")
    @GeneratedValue(generator = "seq",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 30)
    @NotEmpty
    @NotNull
    private String name;

    @Column(precision = 5,scale = 2)
    @Digits(integer = 5,fraction = 2)
    @NotEmpty
    @NotNull
    private BigDecimal factor;

    @JsonIgnore
    @ManyToOne
    private Firm firm;

    @ManyToOne
    @NotEmpty
    @NotNull
    private TypeOf typeOf;
}
