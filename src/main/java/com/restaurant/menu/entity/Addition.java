package com.restaurant.menu.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Data
public class Addition {

    @SequenceGenerator(name = "seq",sequenceName = "additionSeg")
    @GeneratedValue(generator = "seq",strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @NotEmpty
    @NotNull
    @Size(min = 3,max = 50)
    private String name;

    @Digits(integer = 5, fraction = 2)
    @Column(precision = 5,scale = 2)
    private BigDecimal amount;

    @ManyToOne
    private TypeOf typeOf;

    @Transient
    @NotNull
    private Long typeOfId;

    @ManyToOne
    @JsonIgnore
    private Firm firm;

}
