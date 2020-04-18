package org.mgperez;

import io.quarkus.test.junit.QuarkusTest;
import lombok.extern.jbosslog.JBossLog;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@JBossLog
@QuarkusTest
public class GreetingResourceTest {

    //private static final Logger log = Logger.getLogger("ListenerBean");

    @Test
    public void testHelloEndpoint() {
        log.info("processing testHelloEndpoint");

        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}