package com.example.demo.business.service.service;



import com.example.demo.business.Entities.AuthorsEntity;

import java.util.List;

/**
 * Created by davblain on 20.05.2017.
 */
public interface AuthorService extends HibernateService<AuthorsEntity> {

    List<AuthorsEntity> searchByName(String key);

}
