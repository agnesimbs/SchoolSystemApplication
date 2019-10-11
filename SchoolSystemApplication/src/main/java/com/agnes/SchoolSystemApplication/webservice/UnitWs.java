package com.agnes.SchoolSystemApplication.webservice;


import com.agnes.SchoolSystemApplication.bean.UnitBeanI;
import com.google.gson.JsonParser;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/units")
public class UnitWs{
@EJB
    private UnitBeanI unitBeanI;


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
