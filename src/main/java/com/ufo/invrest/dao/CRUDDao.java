/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufo.invrest.dao;

import java.util.List;

/**
 *
 * @author Riza
 */
public interface CRUDDao {
    public Object GetUniqueEntityByNamedQuery(String query, Object... params);
    public List<?> getAll(Class<?> klass);
    public List<?> GetListByNamedQuery(String query, Object... params);
}
