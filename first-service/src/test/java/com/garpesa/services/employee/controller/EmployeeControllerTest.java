package com.garpesa.services.employee.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EmployeeControllerTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/C:/Git/employee")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}