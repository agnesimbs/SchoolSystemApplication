package com.agnes.SchoolSystemApplication.bean;



import com.agnes.SchoolSystemApplication.model.Course;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public class CourseBean extends Bean<Course> implements CourseBeanI {
}
