package com.restaurant.menu.repository;

import com.restaurant.menu.entity.vm.CityVM;
import com.restaurant.menu.entity.vm.CountyVM;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class VMRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<CityVM> findAllCity()
    {
        return entityManager.createQuery("from CityVM",CityVM.class).getResultList();
    }

    public List<CountyVM> findCountyByCityId(Long cityId) {
        return  entityManager.createQuery("from CountyVM where cityId=:cityId",CountyVM.class)
                .setParameter("cityId",cityId)
                .getResultList();
    }
}
