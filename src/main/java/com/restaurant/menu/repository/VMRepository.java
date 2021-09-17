package com.restaurant.menu.repository;

import com.restaurant.menu.entity.Addition;
import com.restaurant.menu.entity.vm.AdditionVM;
import com.restaurant.menu.entity.vm.CityVM;
import com.restaurant.menu.entity.vm.CountyVM;
import com.restaurant.menu.entity.vm.ServingVM;
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

    public List<ServingVM> findAllServing(Long firmId){
        return entityManager.createQuery("from ServingVM where firmId=:firmId",ServingVM.class)
                .setParameter("firmId",firmId)
                .getResultList();
    }

    public List<AdditionVM> findAllAddition(Long firmId, Long typeOfID)
    {
        return entityManager.createQuery("from AdditionVM where firmId=:firmId and typeOfId=:typeOfId",AdditionVM.class)
                .setParameter("firmId",firmId)
                .setParameter("typeOfId",typeOfID)
                .getResultList();
    }

}
