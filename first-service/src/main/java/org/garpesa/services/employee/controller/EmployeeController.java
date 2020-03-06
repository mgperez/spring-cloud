package org.garpesa.services.employee.controller;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.garpesa.services.employee.entity.Employee;
import org.garpesa.services.employee.repository.EmployeeRepository;


@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Inject
    EmployeeRepository repository;
    
    @GET
    @Path("/message")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        LOGGER.info("Hello JavaInUse Called in First Service");
		return "Hello JavaInUse Called in First Service";
	}
    
    @POST
    public Employee add(@Valid Employee employee) {
        LOGGER.info("Employee add: {}", employee);
        return repository.add(employee);
    }
     
    @Path("/{id}")
    @GET
    public Employee findById(@PathParam("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return repository.findById(id);
    }
 
    @GET
    public Set<Employee> findAll() {
        LOGGER.info("Employee find");
        return repository.findAll();
    }
     
    @Path("/department/{departmentId}")
    @GET
    public Set<Employee> findByDepartment(@PathParam("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return repository.findByDepartment(departmentId);
    }
     
    @Path("/organization/{organizationId}")
    @GET
    public Set<Employee> findByOrganization(@PathParam("organizationId") Long organizationId) {
        LOGGER.info("Employee find: organizationId={}", organizationId);
        return repository.findByOrganization(organizationId);
    }
 
}