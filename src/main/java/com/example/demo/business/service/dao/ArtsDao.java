package com.example.demo.business.service.dao;



import com.example.demo.business.Entities.ArtsEntity;

import java.util.List;

/**
 * Created by davblain on 18.05.2017.
 */
public interface ArtsDao extends GenericDao<ArtsEntity,Integer> {
    boolean removeArt(ArtsDao art);
    public Long count();
    List<ArtsEntity> findbykey(String key);


}
