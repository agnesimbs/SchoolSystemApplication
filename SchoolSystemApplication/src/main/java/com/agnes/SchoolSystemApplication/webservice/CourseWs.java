package com.agnes.SchoolSystemApplication.webservice;

import com.agnes.SchoolSystemApplication.bean.CourseBeanI;
import com.google.gson.JsonParser;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("courses")
public class CourseWs {
@EJB
    CourseBeanI courseBeanI;
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
