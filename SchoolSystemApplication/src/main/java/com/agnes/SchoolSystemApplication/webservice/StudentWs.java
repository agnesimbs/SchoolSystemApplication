package com.agnes.SchoolSystemApplication.webservice;

import com.agnes.SchoolSystemApplication.bean.StudentBeanI;
import com.agnes.SchoolSystemApplication.exception.NonUniqueResultException;
import com.agnes.SchoolSystemApplication.model.CustomResponse;
import com.agnes.SchoolSystemApplication.model.Student;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/students")
public class StudentWs {
    @EJB
    private StudentBeanI studentBeanI;


    public CustomResponse customResponseMethod(boolean responseStatus, Object responseData, String responseMessage){
        CustomResponse customResponse=new CustomResponse();
        customResponse.setStatus(responseStatus);
        customResponse.setData(responseData);
        customResponse.setMessage(responseMessage);
        return customResponse;
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(String json) {
        Gson gson = new Gson();
        Student student = gson.fromJson(json, Student.class);
        student = studentBeanI.add(student);

        return Response.ok()
                .entity( customResponseMethod(true,student,"Created Student Successfully"))
                .build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public Response readProductList() throws SQLException {
       return Response.ok().entity(studentBeanI.findAll()).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateStudent")
    public Response updateProduct(String json) {
        Gson gson = new Gson();
        Student student = gson.fromJson(json, Student.class);
        student = studentBeanI.edit(student);
        return Response.ok().entity(student).build();
    }


    //REQUIRED BY FINANCE MODULE,LIBRARY MODULE,EXAM MODULE
    @POST
    @Path("/findStudentByRegistrationNumber")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByRegistrationNumber(String json) throws NonUniqueResultException {
        System.out.println(json);
            String registrationNumber = new JsonParser()
                    .parse(json)
                    .getAsJsonObject()
                    .get("registrationNumber")
                    .getAsString();
            return Response.ok().entity(studentBeanI.findByRegistrationNo(registrationNumber)).build();


    }

    @GET
    @Path("/findStudentById/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findStudentById(@PathParam("studentId") long studentId) {
        return Response.ok().entity(studentBeanI.findById(studentId)).build();
    }

}
