package com.agnes.SchoolSystemApplication.webservice;


import com.agnes.SchoolSystemApplication.bean.UnitBeanI;
import com.agnes.SchoolSystemApplication.model.Unit;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/units")
public class UnitWs{
@EJB
    private UnitBeanI unitBeanI;

    @POST
    @Path("/add")

    @Produces(MediaType.APPLICATION_JSON)
    public Response add(String json) {
        Gson gson = new Gson();
       Unit unit = gson.fromJson(json, Unit.class);
        unit = unitBeanI.add(unit);
        return Response.ok().entity(unit).build();
    }
    @POST
    @Path("/edit")

    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(String json) {
        Gson gson = new Gson();
        Unit unit = gson.fromJson(json, Unit.class);
        unit = unitBeanI.edit(unit);
        return Response.ok().entity(unit).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public Response readProductList() throws SQLException {
        List<Unit> units = unitBeanI.getUnitList();
        return Response.ok().entity(units).build();

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateUnit")
    public Response updateProduct(String json) {
        Gson gson = new Gson();
        Unit unit = gson.fromJson(json, Unit.class);
        unit = unitBeanI.edit(unit);
        return Response.ok().entity(unit).build();
    }

//REQUIRED BY EXAM MODULE

@POST
@Path("/findUnitByUnitCode")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUnitByUnitCode(String json){
    String unitCode=new JsonParser()
            .parse(json)
            .getAsJsonObject()
            .get("unitCode")
            .getAsString();
    return Response.ok().entity(unitBeanI.findByUnitCode(unitCode)).build();

}
}
