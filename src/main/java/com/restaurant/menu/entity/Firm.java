package com.restaurant.menu.entity;

import com.restaurant.menu.shared.UniqueUsername;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Firm extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name = "seq",sequenceName = "firm_seq")
    private Long id;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    @UniqueUsername(table = "FIRM",column = "NAME")
    private String name;

    @NotNull
    @NotEmpty
    @Email
    @Column(length = 50,unique = true)
    @UniqueUsername(table = "FIRM",column = "EMAIL")
    private String email;

    @NotNull
    private Long cityId;

    @NotNull
    private Long countyId;

    @Column(length = 255)
    private String address;

    @NotNull
    @Column(length = 20)
    private String telephone;

    @NotNull
    @Column(length = 50)
    private String responsibleName;

    @OneToMany(mappedBy = "firm")
    private List<User> users;

    @Transient
    @NotNull
    private String password;

    @Lob
    private String logo;
}
