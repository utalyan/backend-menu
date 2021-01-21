package com.restaurant.menu.service;

import com.restaurant.menu.entity.Repast;
import com.restaurant.menu.entity.vm.RepastVM;
import com.restaurant.menu.repository.RepastRepository;
import com.restaurant.menu.shared.UniqueUsernameValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RepastService {

    @Autowired
    RepastRepository repastRepository;

    public static final Logger log = LoggerFactory.getLogger(RepastService.class);

    public List<Repast> getAllRepastWithFirm(Long firmId)
    {
        List<Repast> repasts = repastRepository.findAll();

        return  repasts;
    }

    public Repast save(RepastVM repastVM) {
        Repast repast = new Repast();
        repast.setId(repastVM.getId());
        repast.setName(repastVM.getName());
        repast.setFirm(repastVM.getFirm());

        return repastRepository.save(repast);
    }

    @Transactional
    public void remove(RepastVM repastVM) {
        Repast repast = new Repast();

        repast.setId(repastVM.getId());
        repast.setFirm(repastVM.getFirm());


        repastRepository.deleteByIdAndFirm(repast.getId(),repast.getFirm());

    }
}
