package org.acme;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.checkerframework.checker.units.qual.s;
import org.jboss.logging.Logger;

@Path("/summary/graph")
public class PassengersTimingResource {
    
    private static final Logger LOGGER = Logger.getLogger(PassengersTimingResource.class);

/*     @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create/person")
    public Response createPerson(Person person) {
        //Person s = new Person("John", "Connor", 26);
        if (person != null){
            person.persist();
            return Response.ok().build();
        }
        return Response.noContent().build();
    } */

    @GET   
    @Transactional
    @Path("/passengers_timing")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTroughput(){
        List<PassengersTiming> allTimings = PassengersTiming.findAll().list();
        PassengersTimingFront adaptedTimings = PassengersTimingAdapter.adapt(allTimings);
        // TODO: shitty 
        if (allTimings != null)
            return Response.ok(adaptedTimings).build();            
        return Response.noContent().build();
    }

}