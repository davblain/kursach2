package com.example.demo.business.service.Imp.dao;


import com.example.demo.business.Entities.ArtsEntity;
import com.example.demo.business.service.dao.ArtsDao;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by davblain on 18.05.2017.
 */
@Repository
public class ArtsDaoImp extends HibernateDao<ArtsEntity,Integer> implements ArtsDao {
    public boolean removeArt(ArtsDao art)
    {
        return true;
    }
    public Long count(){
        return (Long)currentSession().createCriteria(ArtsEntity.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }
    
     public List<ArtsEntity> findbykey(String key){
        return currentSession().createCriteria(ArtsEntity.class).add(Restrictions.like("name","%"+key+"%")).list();
    }



}
