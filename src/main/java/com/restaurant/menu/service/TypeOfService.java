package com.restaurant.menu.service;

import com.restaurant.menu.entity.TypeOf;
import com.restaurant.menu.entity.vm.TypeOfVM;
import com.restaurant.menu.repository.TypeOfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfService {

    @Autowired
    TypeOfRepository typeOfRepository;

    public List<TypeOf> getAllWithFirm(Long id) {

        List<TypeOf> typeOfList = typeOfRepository.findByFirmId(id);

        return  typeOfList;

    }

    public TypeOf save(TypeOfVM typeOfVM) {
        TypeOf typeOf = new TypeOf();

        typeOf.setId(typeOfVM.getId());
        typeOf.setName(typeOfVM.getName());
        typeOf.setFirm(typeOfVM.getFirm());

        return typeOfRepository.save(typeOf);
    }

    public void remove(TypeOfVM typeOfVM) {

        typeOfRepository.deleteByIdAndFirmId(typeOfVM.getId(),typeOfVM.getFirm().getId());
    }

    public TypeOf findById(Long typeOfId) {
        return typeOfRepository.findById(typeOfId).get();
    }
}
