package com.agnes.SchoolSystemApplication.webservice;

import com.agnes.SchoolSystemApplication.bean.CourseBeanI;
import com.agnes.SchoolSystemApplication.model.Course;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("courses")
public class CourseWs {
@EJB
    CourseBeanI courseBeanI;
    @POST
    @Path("/add")

    @Produces(MediaType.APPLICATION_JSON)
    public Response add(String json) {
        Gson gson = new Gson();
       Course course = gson.fromJson(json, Course.class);
        course = courseBeanI.add(course);
        return Response.ok().entity(course).build();
    }
    @POST
    @Path("/edit")

    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(String json) {
        Gson gson = new Gson();
        Course course = gson.fromJson(json, Course.class);
        course = courseBeanI.edit(course);
        return Response.ok().entity(course).build();
    }


//REQUIRED BY EXAM MODULE
    @POST
    @Path("/findCourseById")
    @Produces
    public Response findCourseById(String json){
        String courseId=new JsonParser()
                .parse(json)
                .getAsJsonObject()
                .get("courseId")
                .getAsString();
        return Response.ok().entity(courseBeanI.findByCourseId(courseId)).build();
    }



}
