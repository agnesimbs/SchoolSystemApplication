package com.agnes.SchoolSystemApplication.bean;


import com.agnes.SchoolSystemApplication.model.Course;

import javax.ejb.Local;

@Local
public interface CourseBeanI extends BeanI<Course>{
    Course findByCourseId(String courseId);

}
