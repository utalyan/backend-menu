package com.restaurant.menu.service;

import com.restaurant.menu.entity.Repast;
import com.restaurant.menu.entity.vm.RepastVM;
import com.restaurant.menu.repository.RepastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepastService {

    @Autowired
    RepastRepository repastRepository;

    public List<Repast> getAllRepastWithFirm(Long firmId)
    {
        return  repastRepository.findAll();
    }

    public Repast save(RepastVM repastVM) {
        Repast repast = new Repast();
        repast.setId(repastVM.getId());
        repast.setName(repastVM.getName());
        repast.setFirm(repastVM.getFirm());

        return repastRepository.save(repast);
    }
}
