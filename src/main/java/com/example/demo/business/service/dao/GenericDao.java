package com.example.demo.business.service.dao;

/**
 * Created by davblain on 18.05.2017.
 */

import java.util.List;

public interface GenericDao<E, K> {

    void add(E entity);

    void update(E entity);

    void remove(E entity);

    E find(K key);

    List<E> list();
    List<E> list(int first, int col);

}
