package com.agnes.SchoolSystemApplication.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_courses")
@NamedQueries(value = {
        @NamedQuery( name="NQ_FINDBYCOURSEID",
                query = "select u from Course u where u.id=:id")

})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    //....setters and getters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
