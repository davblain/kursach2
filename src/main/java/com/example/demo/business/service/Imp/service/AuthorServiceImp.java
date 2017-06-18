package com.example.demo.business.service.Imp.service;

import com.example.demo.business.Entities.ArtsEntity;
import com.example.demo.business.Entities.AuthorsEntity;
import com.example.demo.business.service.dao.AuthorsDao;
import com.example.demo.business.service.service.AuthorService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by davblain on 20.05.2017.
 */
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
@Service
public class AuthorServiceImp implements AuthorService {

    private AuthorsDao authorsDao;


    public AuthorsDao getAuthorsDao() {
        return authorsDao;
    }
    @Autowired
    public void setAuthorsDao(AuthorsDao authorsDao) {
        this.authorsDao = authorsDao;
    }

    public void add(AuthorsEntity entity) {
        authorsDao.add(entity);
    }
    public void update(AuthorsEntity entity) {
        authorsDao.update(entity);

    }
    public void remove(AuthorsEntity entity) {
        authorsDao.remove(entity);

    }
    public AuthorsEntity find(Integer key) {

        return authorsDao.find(key);
    }

    public List<AuthorsEntity> list() {

        return authorsDao.list();
    }
    public List<AuthorsEntity> list(int first, int col) {

        return authorsDao.list(first,col);
    }
    public List<AuthorsEntity> searchByName(String key)
    {
        return  authorsDao.findbykey(key);

    }

}
