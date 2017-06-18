package com.example.demo.business.service.Imp.dao;

import com.example.demo.business.service.dao.GenericDao;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by davblain on 18.05.2017.
 */
    public class HibernateDao<E, K extends Serializable> implements GenericDao<E, K> {

        private EntityManager entityManager;
        protected Class<? extends E> daoType;

        public HibernateDao() {
            daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0];
        }

        @PersistenceContext
        public void setEntityManager(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        protected Session currentSession() {
            return entityManager.unwrap(Session.class);
        }


        public void add(E entity) {
            currentSession().save(entity);
        }


        public void update(E entity) {
            currentSession().saveOrUpdate(entity);
        }


        public void remove(E entity) {
            currentSession().delete(entity);
        }

        public E find(K key) {
            return (E) currentSession().get(daoType, key);
        }
        public List<E> list() {
            return currentSession().createCriteria(daoType).list();
        }
        public List<E> list(int first,int col)
        {
            return currentSession().createCriteria(daoType).setFirstResult(first).setMaxResults(col).list();
        }



    }