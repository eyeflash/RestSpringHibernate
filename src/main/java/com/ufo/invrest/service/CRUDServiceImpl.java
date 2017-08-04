/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufo.invrest.service;

import com.ufo.invrest.dao.CRUDDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Riza
 */
@Service
public class CRUDServiceImpl implements CRUDService{
    @Autowired
    CRUDDao CRUDDao;
    
    @Override
    @Transactional
    public List<?> getAll(Class<?> klass) {
        return CRUDDao.getAll(klass);
    }

    @Override
    @Transactional
    public Object GetUniqueEntityByNamedQuery(String query, Object... params) {
        return CRUDDao.GetUniqueEntityByNamedQuery(query, params);
    }

    @Override
    @Transactional
    public List<?> GetListByNamedQuery(String query, Object... params) {
        return CRUDDao.GetListByNamedQuery(query, params);
    } 
}
