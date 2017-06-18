package com.example.demo.business.service.Imp.service;


import com.example.demo.business.Entities.ArtsEntity;
import com.example.demo.business.service.dao.ArtsDao;
import com.example.demo.business.service.dao.GenresDao;

import com.example.demo.business.service.service.ArtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by davblain on 23.05.2017.
 */
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
@Service
public class ArtsServiceImp implements ArtsService {

    ArtsDao artsDao;
    GenresDao genresDao;

    public ArtsDao getArtsDao() {
        return artsDao;
    }

    @Autowired
    public void setArtsDao(ArtsDao artsDao) {
        this.artsDao = artsDao;
    }



    public GenresDao getGenresDao() {
        return genresDao;
    }
    @Autowired
    public void setGenresDao(GenresDao genresDao) {
        this.genresDao = genresDao;
    }

    @Override
    public void add(ArtsEntity entity) {
        if (entity.getGenre()==null)
            entity.setGenre(genresDao.find(4));
        artsDao.add(entity);
    }

    @Override
    public void update(ArtsEntity entity) {
        artsDao.add(entity);
    }

    @Override
    public void remove(ArtsEntity entity) {
        artsDao.remove(entity);
    }

    @Override
    public ArtsEntity find(Integer key) {


        ArtsEntity art=artsDao.find(key);
        return art;
    }

    @Override
    public List<ArtsEntity> list() {
        return artsDao.list();
    }

    @Override
    public List<ArtsEntity> list(int first, int col) {
        return artsDao.list(first,col);
    }
    public List<ArtsEntity> searchByName(String key)
    {
        return  artsDao.findbykey(key);

    }
}



