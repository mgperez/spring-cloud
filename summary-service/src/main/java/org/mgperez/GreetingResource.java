package org.mgperez;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.extern.jbosslog.JBossLog;

@JBossLog
@Path("/hello")
public class GreetingResource { 

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        log.info("processing hello");
        return "hello";
    }
}