package com.agnes.SchoolSystemApplication.bean;



import com.agnes.SchoolSystemApplication.model.Course;
import com.agnes.SchoolSystemApplication.model.Unit;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public class CourseBean extends Bean<Course> implements CourseBeanI {
    @Override
    public Course findByCourseId(String courseId) {
        return this.entityManager
                .createNamedQuery("NQ_FINDBYCOURSEID",Course.class)
                .setParameter("id",courseId)
                .getSingleResult();

    }
}
