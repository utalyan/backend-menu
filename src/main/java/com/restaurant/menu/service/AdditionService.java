package com.restaurant.menu.service;

import com.restaurant.menu.auth.AuthUserDetails;
import com.restaurant.menu.entity.Addition;
import com.restaurant.menu.entity.TypeOf;
import com.restaurant.menu.entity.User;
import com.restaurant.menu.entity.vm.AdditionVM;
import com.restaurant.menu.repository.AdditionRepository;
import com.restaurant.menu.repository.TypeOfRepository;
import com.restaurant.menu.repository.UserRepository;
import com.restaurant.menu.repository.VMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdditionService {


    @Autowired
    AdditionRepository additionRepository;

    @Autowired
    VMRepository vmRepository;

    @Autowired
    TypeOfRepository typeOfRepository;

    @Autowired
    UserRepository userRepository;

    public List<AdditionVM> findByFirmId(Long firmId, Long typeOfId) {
        List<AdditionVM> additionVMS = vmRepository.findAllAddition(firmId,typeOfId);

        return additionVMS;
    }

    public Addition save(Addition addition) {
        AuthUserDetails authUserDetails =  (AuthUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepository.findById(authUserDetails.getUserId()).get();

        addition.setFirm(user.getFirm());

        TypeOf typeOf = typeOfRepository.findById(addition.getTypeOfId()).get();
        addition.setTypeOf(typeOf);

        return additionRepository.save(addition);
    }

    public void deleteById(Long id) {
        additionRepository.deleteById(id);
    }
}
