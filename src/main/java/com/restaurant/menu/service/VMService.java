package com.restaurant.menu.service;

import com.restaurant.menu.entity.vm.CityVM;
import com.restaurant.menu.entity.vm.CountyVM;
import com.restaurant.menu.repository.VMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VMService {


    @Autowired
    VMRepository vmRepository;

    public List<CityVM> getCityList()
    {
        return vmRepository.findAllCity();
    }

    public List<CountyVM> getCountyByCityId(Long cityId) {

        return vmRepository.findCountyByCityId(cityId);
    }

}
