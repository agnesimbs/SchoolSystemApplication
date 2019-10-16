package com.agnes.SchoolSystemApplication.bean;


import com.agnes.SchoolSystemApplication.exception.NonUniqueResultException;
import com.agnes.SchoolSystemApplication.model.Student;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.Inheritance;

import java.util.List;
@Inheritance
@Local
@Stateless
public class StudentBean extends Bean<Student> implements StudentBeanI{
@PostConstruct
    public void init(){
    this.entityClass=Student.class;
}

    @Resource
    private SessionContext sessionContext;
    @Override
    public List<Student> findAll()
    {
        return this.entityManager.createNamedQuery("NQ_FIND_ALL").getResultList();
    }

    @Override
    public Student findByRegistrationNo(String registrationNumber) throws NonUniqueResultException {
            List<Student> student=
                 this.entityManager
                        .createNamedQuery("NQ_FINDBYREGNO",Student.class)
                        .setParameter("registrationNumber",registrationNumber)
                        .getResultList();
            if(student.isEmpty())
            {
                return null;
            }
            else if (student.size()==1){
                return student.get(0);
            }else {
                throw new NonUniqueResultException();

            }
    }

    /*@Override
    public List<Student> getStudentList() throws SQLException {
        return null;
    }*/
}
