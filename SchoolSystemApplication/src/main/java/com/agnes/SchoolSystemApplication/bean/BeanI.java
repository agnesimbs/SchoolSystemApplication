package com.agnes.SchoolSystemApplication.bean;

import javax.ejb.Local;
import java.util.List;
@Local
public interface BeanI <T>{
    T add(T t);
    T edit(T t);
    T findById(long id);
    List<T> findAll();
    boolean delete(T t);
}
