package org.garpesa.services.consumer.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/consumers")
public class ConsumerController {

  
  private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @GET
    @Path("/message")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
      LOGGER.info("Hello JavaInUse Called in Second Service");
		return "Hello JavaInUse Called in Second Service";
	}
}