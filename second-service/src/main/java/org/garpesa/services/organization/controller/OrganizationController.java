package org.garpesa.services.organization.controller;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.garpesa.services.organization.client.DepartmentClient;
import org.garpesa.services.organization.client.EmployeeClient;
import org.garpesa.services.organization.model.Organization;
import org.garpesa.services.organization.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/organizations")
@Produces(MediaType.APPLICATION_JSON)
public class OrganizationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Inject
    OrganizationRepository repository;
    @Inject
    @RestClient
    DepartmentClient departmentClient;
    @Inject
    @RestClient
    EmployeeClient employeeClient;

    @POST
    public Organization add(@Valid Organization organization) {
        LOGGER.info("Organization add: {}", organization);
        return repository.add(organization);
    }

    @GET
    public Set<Organization> findAll() {
        LOGGER.info("Organization find");
        return repository.findAll();
    }

    @Path("/{id}")
    @GET
    public Organization findById(@PathParam("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        return repository.findById(id);
    }

    @Path("/{id}/with-departments")
    @GET
    public Organization findByIdWithDepartments(@PathParam("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = repository.findById(id);
        organization.setDepartments(departmentClient.findByOrganization(organization.getId()));
        return organization;
    }

    @Path("/{id}/with-departments-and-employees")
    @GET
    public Organization findByIdWithDepartmentsAndEmployees(@PathParam("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = repository.findById(id);
        organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
        return organization;
    }

    @Path("/{id}/with-employees")
    @GET
    public Organization findByIdWithEmployees(@PathParam("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = repository.findById(id);
        organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
        return organization;
    }

}
