package com.agnes.SchoolSystemApplication.bean;

import com.agnes.SchoolSystemApplication.model.Course;
import com.agnes.SchoolSystemApplication.model.Unit;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NonUniqueResultException;
import java.util.List;

@Local
@Stateless
public class CourseBean extends Bean<Course> implements CourseBeanI {
    @Override
    public Course findByCourseId(String courseId) {
        List<Course> courses=
                this.entityManager
                .createNamedQuery("NQ_FINDBYCOURSEID",Course.class)
                .setParameter("id",courseId)
                .getResultList();
        if(courses.isEmpty())
        {
            return null;
        }
        else if (courses.size()==1){
            return courses.get(0);
        }else {
            throw new NonUniqueResultException();

        }

    }
}
