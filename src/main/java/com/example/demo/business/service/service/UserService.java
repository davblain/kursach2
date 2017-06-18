package com.example.demo.business.service.service;

import com.example.demo.business.Entities.UserEntity;

import java.util.List;

/**
 * Created by Gemini on 18.05.2017.
 */
public interface UserService extends HibernateService<UserEntity> {
    List<UserEntity> GetListOfUsersWithGroup(int i);//лист юсеров данной группы


}
