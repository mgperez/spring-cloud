Implement First Microservice

https://www.youtube.com/watch?v=dZ8Z5DpcdrM

https://www.javainuse.com/spring/cloud-gateway

https://github.com/spring-guides/gs-gateway





https://dzone.com/articles/quick-guide-to-microservices-with-quarkus-on-opens

https://dzone.com/articles/build-a-java-rest-api-with-quarkus



Quarkus

https://quarkus.io/guides/maven-tooling

https://code.quarkus.io/

https://quarkus.io/guides/getting-started

https://quarkus.io/guides/rest-json

https://quarkus.io/quarkus-workshops/super-heroes/



https://quarkus.io/blog/quarkus-for-spring-developers/



how to secure it

https://developer.okta.com/blog/2019/09/30/java-quarkus-oidc



JSON binding standard

https://www.baeldung.com/java-json-binding-api

https://developer.ibm.com/technologies/java/articles/j-javaee8-json-binding-4/



This command generates a Maven structure importing the extensions:

- RESTEasy JSON-B:  Java API for JSON Binding (JSR 367: JSON-B API) serialization support for RESTEasy
- Hibernate Validator: Validate data coming to your REST endpoints

```
mvn io.quarkus:quarkus-maven-plugin:1.2.1.Final:create \
    -DprojectGroupId=com.garpesa.services \
    -DprojectArtifactId=first-service \
    -DclassName="com.garpesa.services.employee.controller.EmployeeController" \
    -Dpath="/employees" \
    -Dextensions="resteasy-jsonb, hibernate-validator"
```

Run the project:

```
./mvnw compile quarkus:dev
```

Now, if run the application employee-service locally in development mode by executing Maven command:

 mvn compile quarkus:dev 



you may view API specification available under URL http://localhost:8080/swagger-ui/.



#### Open API

Now, you *curl* `http://localhost:8080/openapi` endpoint:



unset HTTP_PROXY

curl -X GET "http://localhost:8080/employees/message"





Implement Second Microservice

```
mvn io.quarkus:quarkus-maven-plugin:1.2.1.Final:create \
    -DprojectGroupId=com.garpesa.services \
    -DprojectArtifactId=second-service \
    -DclassName="com.garpesa.services.consumer.controller.ConsumerController" \
    -Dpath="/consumers" \
    -Dextensions="resteasy-jsonb, hibernate-validator"
```

curl -X GET "http://localhost:8082/consumers/message"