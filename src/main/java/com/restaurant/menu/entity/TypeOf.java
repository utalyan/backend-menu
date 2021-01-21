package com.restaurant.menu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TypeOf {

    @Id
    @SequenceGenerator(sequenceName = "typeof_seq",name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column(length = 30)
    private String name;

    @JsonIgnore
    @OneToOne
    Firm firm;

}
