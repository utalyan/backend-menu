package com.restaurant.menu.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MenuDetail {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "menu_detail_seq")
    @GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Food food;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Menu menu;

}
