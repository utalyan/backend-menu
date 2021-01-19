package com.restaurant.menu.entity.vm;

import com.restaurant.menu.entity.User;
import lombok.Data;

@Data
public class UserVM {

    private String username;
    private String surname;
    private String telephone;
    private String firmName;
    private String logo;

    public UserVM(User user) {
        this.username = user.getUsername();
        this.surname = user.getSurname();
        this.telephone = user.getTelephone();
        this.firmName = user.getFirm().getName();
        this.logo = user.getFirm().getLogo();

    }
}
