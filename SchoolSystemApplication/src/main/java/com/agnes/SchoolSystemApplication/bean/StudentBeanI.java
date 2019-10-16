package com.agnes.SchoolSystemApplication.bean;

import com.agnes.SchoolSystemApplication.exception.NonUniqueResultException;
import com.agnes.SchoolSystemApplication.model.Student;


import javax.ejb.Local;


@Local
public interface StudentBeanI extends BeanI<Student> {

    Student findByRegistrationNo(String registrationNumber) throws NonUniqueResultException;

}
