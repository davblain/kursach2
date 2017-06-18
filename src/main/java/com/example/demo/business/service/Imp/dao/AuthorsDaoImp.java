package com.example.demo.business.service.Imp.dao;


import com.example.demo.business.Entities.ArtsEntity;
import com.example.demo.business.Entities.AuthorsEntity;
import com.example.demo.business.service.dao.AuthorsDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by davblain on 20.05.2017.
 */
@Repository
public class AuthorsDaoImp extends HibernateDao<AuthorsEntity,Integer> implements AuthorsDao {
    @Override
    public List<AuthorsEntity> findbykey(String key) {
            return currentSession().createCriteria(AuthorsEntity.class).add(Restrictions.like("name","%"+key+"%")).list();
        }

    }

