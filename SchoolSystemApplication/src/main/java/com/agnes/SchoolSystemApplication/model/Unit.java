package com.agnes.SchoolSystemApplication.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_course_units")

@NamedQueries(value = {
        @NamedQuery(
                name="NQ_FINDBYUNITCODE",
                query = "select u from Unit u where u.unitCode=:unitCode"
        )

})
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String unitCode;
    private String unitName;
    @ManyToOne
    private Course course;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", unitCode='" + unitCode + '\'' +
                ", unitName='" + unitName + '\'' +
                ", course=" + course +
                '}';
    }
}
