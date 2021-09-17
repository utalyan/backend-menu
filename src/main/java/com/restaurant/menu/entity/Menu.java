package com.restaurant.menu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Menu {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "menu_seq")
    @GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotEmpty
    @Size(min = 5, max = 255)
    private String name;

    @Column(precision = 7, scale = 2)
    @Digits(integer = 7, fraction = 2)
    private BigDecimal price;

    @JsonIgnore
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<MenuDetail> menuDetailList;

    @JsonIgnore
    @ManyToOne
    private Firm firm;
}
