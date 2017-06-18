package com.example.demo.business.service.service;



import com.example.demo.business.Entities.ArtsEntity;

import java.util.List;

/**
 * Created by davblain on 20.05.2017.
 */
public interface ArtsService extends HibernateService<ArtsEntity>{
    List<ArtsEntity> searchByName(String key);
}
