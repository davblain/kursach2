package com.example.demo.business.service.Imp.dao;


import com.example.demo.business.Entities.UserEntity;
import com.example.demo.business.service.dao.UserDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Gemini on 18.05.2017.
 */
@Repository
public class UserDaoImp extends HibernateDao<UserEntity,Integer> implements UserDao {
    public List<UserEntity> GetListOfUsersWithGroup(int i) {
        return  currentSession().createCriteria(UserEntity.class).add(Restrictions.eq("group",i)).list();
    }

}
