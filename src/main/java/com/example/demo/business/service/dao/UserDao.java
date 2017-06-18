package com.example.demo.business.service.dao;

import com.example.demo.business.Entities.UserEntity;

import java.util.List;

/**
 * Created by davblain on 18.05.2017.
 */
public interface UserDao extends GenericDao<UserEntity,Integer> {
    List<UserEntity> GetListOfUsersWithGroup(int i);


}
