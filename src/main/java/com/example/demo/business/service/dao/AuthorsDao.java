package com.example.demo.business.service.dao;


import com.example.demo.business.Entities.ArtsEntity;
import com.example.demo.business.Entities.AuthorsEntity;

import java.util.List;

/**
 * Created by davblain on 18.05.2017.
 */
public interface AuthorsDao extends GenericDao<AuthorsEntity,Integer> {
    List<AuthorsEntity> findbykey(String key);

}
