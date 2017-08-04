/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufo.invrest.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Riza
 */
@Repository
public class CRUDDaoImpl implements CRUDDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Object GetUniqueEntityByNamedQuery(String query, Object... params) {
       Query q = sessionFactory.getCurrentSession().getNamedQuery(query);

        int i = 1;
        String arg = "arg";
        if (params != null) {
            for (Object o : params) {
                if (o != null) {
                    if (o instanceof List) {
                        q.setParameterList(arg + i, (List) o);
                    } else {
                        q.setParameter(arg + i, o);
                    }

                    i++;
                }
            }
        }
        return q.uniqueResult();
    }

    @Override
    public List<?> getAll(Class<?> klass) {
         return getCurrentSession().createQuery("from " + klass.getName()).list();
    }

    @Override
    public List<?> GetListByNamedQuery(String query, Object... params) {
        Query q = sessionFactory.getCurrentSession().getNamedQuery(query);

        int i = 1;
        String arg = "arg";
        if (params != null) {
            for (Object o : params) {
                if (o != null) {
                    if (o instanceof List) {
                        q.setParameterList(arg + i, (List) o);
                    } else {
                        q.setParameter(arg + i, o);
                    }

                    i++;
                }
            }
        }
        return q.list();
    }

}
