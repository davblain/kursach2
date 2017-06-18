package com.example.demo.business.service.Imp.service;



import com.example.demo.business.Entities.UserEntity;
import com.example.demo.business.service.dao.UserDao;
import com.example.demo.business.service.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by Gemini on 18.05.2017.
 */
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
@Service
public class UserServiceImp implements UserService {


    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }


    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void add(UserEntity entity) {
        userDao.add(entity);
    }
    public void update(UserEntity entity) {
        userDao.update(entity);

    }
    public void remove(UserEntity entity) {
        userDao.remove(entity);

    }
    public UserEntity find(Integer key) {
        return userDao.find(key);
    }
    public List<UserEntity> list() {
        return userDao.list();
    }
    public List<UserEntity> list(int first, int col) {
        return userDao.list(first,col);
    }
    public List<UserEntity> GetListOfUsersWithGroup(int i) {

        return userDao.GetListOfUsersWithGroup(i);
    }


}
