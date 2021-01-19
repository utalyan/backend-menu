package com.restaurant.menu.entity;

import com.restaurant.menu.shared.UniqueUsername;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class User extends BaseEntity {
    @Id
    @GeneratedValue(generator = "seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "user_seq",name = "seq")
    private Long id;

    @Column(unique = true,length = 30)
    @UniqueUsername(table = "USER",column = "USERNAME")
    private String username;

    private String password;

    @NotNull
    @NotEmpty
    @Column(length = 50)
    private String name;

    @NotNull
    @NotEmpty
    @Column(length = 50)
    private String surname;

    @NotNull
    @Email
    String email;

    @Column(length = 30)
    private String telephone;

    @ManyToOne
    Firm firm;
}
