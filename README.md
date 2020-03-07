Tutorial

https://www.youtube.com/watch?v=dZ8Z5DpcdrM

https://www.youtube.com/watch?v=Aty83SQD8O4



https://www.javainuse.com/spring/cloud-gateway

https://github.com/TechPrimers/spring-cloud-eureka-and-hystrix-example



OAuth 2 + Json Web Tokens

https://medium.com/@yellow/rest-security-basics-f59013850c4e

https://quarkus.io/guides/security

Spring Cloud Gateway with OpenID Connect and Token Relay

https://blog.jdriven.com/2019/11/spring-cloud-gateway-with-openid-connect-and-token-relay/

https://picodotdev.github.io/blog-bitix/2019/02/servidor-oauth-gateway-y-servicio-rest-utilizando-tokens-jwt-con-spring/

https://www.baeldung.com/spring-security-zuul-oauth-jwt

https://www.xoriant.com/blog/product-engineering/microservices-security-using-jwt-authentication-gateway.html

https://spring.io/blog/2019/08/16/securing-services-with-spring-cloud-gateway

**Spring**

https://github.com/spring-guides/gs-gateway

https://spring.io/guides/gs/gateway/



**Netflix**

https://github.com/Netflix/zuul/wiki

https://github.com/Netflix/zuul/wiki/Getting-Started-2.0





https://dzone.com/articles/quick-guide-to-microservices-with-quarkus-on-opens

https://dzone.com/articles/build-a-java-rest-api-with-quarkus



Quarkus

https://quarkus.io/guides/maven-tooling

https://code.quarkus.io/

https://quarkus.io/guides/getting-started

https://quarkus.io/guides/rest-json

https://quarkus.io/quarkus-workshops/super-heroes/



https://quarkus.io/blog/quarkus-for-spring-developers/

https://www.javacodegeeks.com/2020/02/getting-started-with-quarkus.html



Git

https://www.3pillarglobal.com/insights/tutorial-how-to-manage-git-branches-using-gitflow



**~/.gitconfig**

Maven

https://blog.softwaremill.com/graalvm-installation-and-setup-on-macos-294dd1d23ca2

Cannot find the `native-image` in the GRAALVM_HOME, JAVA_HOME and System PATH. Install it using `gu install native-image`

https://www.graalvm.org/docs/reference-manual/native-image/#graalvm-native-image

https://www.graalvm.org/docs/reference-manual/install-components/

~/.bash_profile

how to secure it

https://developer.okta.com/blog/2019/09/30/java-quarkus-oidc



JSON binding standard

https://www.baeldung.com/java-json-binding-api

https://developer.ibm.com/technologies/java/articles/j-javaee8-json-binding-4/



**Implement First Microservice** 

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

tar -xvf first-service.zip

Run the project: (runs Quarkus in development mode.)

```
./mvnw compile quarkus:dev -Ddebug=false
./mvnw clean package -Pnative
./mvnw clean package
java -jar target/first-service-1.0.0-SNAPSHOT-runner.jar
```

Now, if run the application employee-service locally in development mode by executing Maven command:

 mvn compile quarkus:dev 

http://localhost:8080/hello



you may view API specification available under URL http://localhost:8080/swagger-ui/.



#### Open API

Now, you *curl* `http://localhost:8080/openapi` endpoint:



unset HTTP_PROXY

curl -X GET "http://localhost:8081/employees/message"





**Implement Second Microservice**

```
mvn io.quarkus:quarkus-maven-plugin:1.2.1.Final:create \
    -DprojectGroupId=org.garpesa.services \
    -DprojectArtifactId=second-service \
    -DclassName="org.garpesa.services.consumer.controller.ConsumerController" \
    -Dpath="/consumers" \
    -Dextensions="resteasy-jsonb, hibernate-validator"
```

curl -X GET "http://localhost:8082/consumers/message"



**Implement Spring Cloud Gateway**

https://start.spring.io/

https://spring.io/guides/gs/maven/

To run your own gateway use the `spring-cloud-starter-gateway` dependency.

Selected dependencies

- [**Gateway**
  Provides a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as security, monitoring/metrics, and resiliency.](https://start.spring.io/)

Run the project:

```
./mvnw package -DskipTests
java -jar target/cloud-gateway-service-0.0.1-SNAPSHOT.jar
```

```bash
$ curl http://localhost:8080/get
```

https://spring.io/guides/gs/gateway/

https://www.javainuse.com/spring/cloud-gateway

