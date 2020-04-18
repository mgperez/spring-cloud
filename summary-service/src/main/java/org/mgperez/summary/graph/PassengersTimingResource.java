package org.mgperez.summary.graph;

import lombok.extern.jbosslog.JBossLog;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@JBossLog
@Path("/summary/graph")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PassengersTimingResource {


/*    @Inject
    private PassengersTimingDao dao;

    @Inject
    private PassengersTimingMapper mapper;*/

    @GET
    @Path("/passengers_timing")
    public List<PassengersTiming> getAll(){
        //return dao.findAll().list();
        return PassengersTiming.listAll();
    }

    @GET
    @Path("/passengers_timing/mapper")
    public PassengersTimingFront allMapper(){
        PassengersTimingFront front = new PassengersTimingFront();

        List<String> labels = new ArrayList<String>(); //= Collections.emptyList();
        List<Float> data = new ArrayList<Float>(); //= Collections.emptyList();
        List<DataFront> datasets = new ArrayList<DataFront>(); //= Collections.<DataFront>emptyList();

        List<PassengersTiming> arrlist = PassengersTiming.findAll().list();

        ListIterator<PassengersTiming>
                iterator = arrlist.listIterator();

        while (iterator.hasNext()) {
            PassengersTiming timing = iterator.next();
            labels.add(timing.getXLabel());
            data.add(timing.getYValue());
        }

        datasets.add(new DataFront(data));

        front.setLabels(labels);
        front.setDatasets(datasets);
        return front;
    }


/*
    @GET
    @Path("/passengers_timing/mapper")
    public PassengersTimingFront allMapper(){
        PassengersTimingDto person = new PassengersTimingDto(PassengersTimingV.listAll());
        return mapper.toFront(person);
    }
    @GET
    public long count(){
        return dao.count();
    }
*/

    @RolesAllowed({"Everyone"})
    @POST
    @Transactional
    public Response  create(@Valid PassengersTiming pt) {
        pt.persist();
        return Response.status(Response.Status.CREATED).entity(pt).build();
    }
}
