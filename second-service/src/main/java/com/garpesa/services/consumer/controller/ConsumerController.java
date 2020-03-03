package com.garpesa.services.consumer.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/consumers")
public class ConsumerController {

    @GET
    @Path("/message")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
		return "Hello JavaInUse Called in Second Service";
	}
}