package org.acme;

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

@Path("/summary/table")
public class TroughputResource {
    
    private static final Logger LOGGER = Logger.getLogger(TroughputResource.class);

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
    @Path("/throughput")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTroughput(){
        Throughput t = Throughput.findAll().firstResult();
        //Throughput t = Throughput.find("select nopassengers, previousperiod from throughput");
        if (t != null)
            return Response.ok(t).build();            
        return Response.noContent().build();
    }

}