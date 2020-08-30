/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.digital.employessapplication.api;

import co.com.digital.employessapplication.dto.GenericResponse;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import co.com.digital.employessapplication.bean.EmployeesLocal;
import co.com.digital.employessapplication.dto.RequestEmployee;
import co.com.digital.employessapplication.entity.Employee;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

/**
 *
 * @author munozbryg
 */
@Path("employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class EmployeesRest {

    @EJB
    EmployeesLocal bean;

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GenericResponse create(RequestEmployee employee) {
        return bean.create(employee);
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> get() {

        return bean.get();
    }

    @GET
    @Path("getById")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getById(@QueryParam("id") int id) {
        return bean.getById(id);
    }

    @PUT
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GenericResponse update(RequestEmployee employee) {
        return bean.update(employee);

    }

    @DELETE
    @Path("disable")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse disable(@QueryParam("id") int id) {
        return bean.disable(id);
    }
}
