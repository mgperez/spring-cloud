package org.acme.v1;

import org.jboss.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/summary/graph/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PassengersTimingResource {
    private static final Logger LOGGER = Logger.getLogger(PassengersTimingResource.class);

    @Inject
    private PassengersTimingDao dao;

    @Inject
    private PassengersTimingMapper mapper;

    @GET
    @Path("/passengers_timing")
    public List<PassengersTimingV1> all(){
        //return dao.findAll().list();
        return PassengersTimingV1.listAll();
    }
    @GET
    @Path("/passengers_timing/mapper")
    public PassengersTimingFront allMapper(){
        PassengersTimingDto person = new PassengersTimingDto(PassengersTimingV1.listAll());
        return mapper.toFront(person);
    }
    @GET
    public long count(){
        return dao.count();
    }

    @RolesAllowed({"Everyone"})
    @POST
    public void save(PassengersTimingV1 workshop) {
        workshop.persist();
    }
}
