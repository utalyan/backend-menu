package com.restaurant.menu.service;

import com.restaurant.menu.entity.Firm;
import com.restaurant.menu.entity.User;
import com.restaurant.menu.repository.FirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FirmService {

    @Autowired
    FirmRepository firmRepository;

    @Autowired
    UserService userService;

    public void create(Firm firm) {
        firmRepository.save(firm);

        User user = new User();
        user.setEmail(firm.getEmail());
        user.setName(firm.getName());
        user.setSurname(firm.getName());
        user.setPassword(firm.getPassword());
        user.setUsername(firm.getEmail());
        user.setTelephone(firm.getTelephone());
        user.setFirm(firm);

        userService.create(user);

    }
}
