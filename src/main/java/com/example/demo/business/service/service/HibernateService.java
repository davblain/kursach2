package com.example.demo.business.service.service;

import java.util.List;

/**
 * Created by davblain on 20.05.2017.
 */
public interface HibernateService<E> {
    void add(E entity);
    void update(E entity);
    void remove(E entity);
    E find(Integer key);
    List<E> list();
    List<E> list(int first, int col);
}
