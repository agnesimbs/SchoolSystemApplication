package com.agnes.SchoolSystemApplication.bean;

import com.agnes.SchoolSystemApplication.model.Student;


import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface StudentBeanI extends BeanI<Student> {
    List<Student> findAll();
    Student findByRegistrationNo(String registrationNumber);
    List<Student> getStudentList() throws SQLException;
}
