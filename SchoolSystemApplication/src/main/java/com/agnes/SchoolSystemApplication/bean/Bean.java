package com.agnes.SchoolSystemApplication.bean;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

@Local
@Stateless
public class Bean<T> implements BeanI<T> {
    @PersistenceContext(unitName = "EJB")
    protected EntityManager entityManager;
    protected Class<T> entityClass;

    @Override
    public T add(T t) {
         try {
             entityManager.persist(t);
             return t;
         }catch (PersistenceException e){
             return null;
         }
    }

    @Override
    public T edit(T t) {
        try {
            entityManager.merge(t);
            return t;
        }catch (PersistenceException e){
            return null;
        }
    }

    @Override
    public T findById(long id) {
        return  entityManager.find(entityClass,id);
    }


    @Override
    public List<T> findAll() {
        try {
            return entityManager.createQuery("select t from " + entityClass.getSimpleName() + " t where t.deleted = 'false'").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public boolean delete(T t) {
       try{
           entityManager.remove(t);
           return true;
       }
       catch (PersistenceException e){
           return false;
       }
    }
}
