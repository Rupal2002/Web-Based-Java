package com.mueseum.Dao;


import java.sql.SQLException;
import java.util.Collection;

public interface jdbcDao<T,K> 
{
    Boolean save(T t) throws SQLException;
    
    Collection<T>  findAll() throws SQLException;
    
    T findById(K key)  throws SQLException;
    
    void update(T t) throws SQLException;
    
    void delete(K key) throws SQLException;
}
