package com.restaurant.menu.service;

import com.restaurant.menu.entity.Serving;
import com.restaurant.menu.entity.User;
import com.restaurant.menu.entity.vm.ServingVM;
import com.restaurant.menu.repository.ServingRepository;
import com.restaurant.menu.repository.VMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServingService {

    @Autowired
    ServingRepository servingRepository;

    @Autowired
    VMRepository vmRepository;

    public List<ServingVM> getAllServing(User user) {

        return vmRepository.findAllServing(user.getFirm().getId());

    }

    public Serving save(Serving serving) {
        return servingRepository.save(serving);
    }

    public void deleteById(Long id) {
        servingRepository.deleteById(id);
    }
}
