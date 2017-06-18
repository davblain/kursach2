package com.example.demo.business.service.Imp.dao;

import com.example.demo.business.Entities.GenresEntity;
import com.example.demo.business.service.dao.GenresDao;
import org.springframework.stereotype.Repository;

/**
 * Created by davblain on 25.05.2017.
 */
@Repository
public class GenresDaoImp extends HibernateDao<GenresEntity,Integer> implements GenresDao {

}
