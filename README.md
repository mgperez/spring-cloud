Tutorial

https://www.youtube.com/watch?v=dZ8Z5DpcdrM

https://www.youtube.com/watch?v=Aty83SQD8O4



https://www.javainuse.com/spring/cloud-gateway

https://github.com/TechPrimers/spring-cloud-eureka-and-hystrix-example



My experiences with API gateways…

https://medium.com/@mahesh.mahadevan/my-experiences-with-api-gateways-8a93ad17c4c4

https://medium.com/devops-faith/an-api-gateway-is-not-the-new-unicorn-303a3863f2a6



https://www.krakend.io/

https://github.com/solo-io/gloo

https://www.nginx.com/

https://konghq.com/

https://tyk.io/

https://www.getambassador.io/

https://docs.apigee.com/

https://wso2.com/

https://github.com/Netflix/zuul





OAuth 2 + Json Web Tokens

https://medium.com/@yellow/rest-security-basics-f59013850c4e

https://quarkus.io/guides/security

Spring Cloud Gateway with OpenID Connect and Token Relay

https://blog.jdriven.com/2019/11/spring-cloud-gateway-with-openid-connect-and-token-relay/

https://github.com/timtebeek/spring-security-samples



https://picodotdev.github.io/blog-bitix/2019/02/servidor-oauth-gateway-y-servicio-rest-utilizando-tokens-jwt-con-spring/

https://www.baeldung.com/spring-security-zuul-oauth-jwt

https://www.xoriant.com/blog/product-engineering/microservices-security-using-jwt-authentication-gateway.html

https://spring.io/blog/2019/08/16/securing-services-with-spring-cloud-gateway

https://howtodoinjava.com/spring-cloud/spring-cloud-api-gateway-zuul/



Spring Cloud Gateway Tutorial

https://medium.com/@niral22/spring-cloud-gateway-tutorial-5311ddd59816

https://www.baeldung.com/spring-cloud-custom-gateway-filters

https://programmer.help/blogs/second-generation-microservice-gateway-component-spring-cloud-gateway.html

Secure Spring Cloud Gateway with OAuth 2.0

https://morioh.com/p/0f35d4bf423b



Sentinel: Supports Spring Cloud Gateway

https://www.javaspring.net/sentinel/sentinel-supports-spring-cloud-gateway



Implementing an On-Premises Identity Management Solution?

Okta (identity management) -- cloud identity provider

https://developer.okta.com/blog/2020/01/08/secure-legacy-spring-cloud-gateway

https://morioh.com/p/0f35d4bf423b

You can use OAuth 2.0 and OIDC (OpenID Connect) without a cloud identity provider by building your own server or by using an open-source implementation. 



https://www.keycloak.org/ (Open Source Identity and Access Management)



Make Your Gateway an OAuth 2.0 Resource Server

https://morioh.com/p/0f35d4bf423b



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
./mvnw clean package -DskipTests
java -jar target/first-service-1.0.0-SNAPSHOT-runner.jar
```

Containerization

https://github.com/lreimer/hands-on-quarkus

```
./mvnw clean package -DskipTests
docker build -f src/main/docker/Dockerfile.jvm -t mgperez/first-service:jvm .
docker run -i --rm -p 8081:8081 mgperez/first-service:jvm
```

Native:

```
mvn package -Pnative -Dnative-image.docker-build=true
docker-compose up --build

docker build -f src/main/docker/Dockerfile.native -t lreimer/hands-on-quarkus:native .
docker run -i --rm -p 8080:8080 lreimer/hands-on-quarkus:native
```



Now, if run the application employee-service locally in development mode by executing Maven command:

 mvn compile quarkus:dev 

http://localhost:8080/hello



you may view API specification available under URL http://localhost:8080/swagger-ui/.



#### Open API

Now, you *curl* `http://localhost:8080/openapi` endpoint:



unset HTTP_PROXY

```
curl -X GET "http://localhost:8081/employees/message"

curl -X GET "http://localhost:8081/health"
```



**Implement Second Microservice**

```
mvn io.quarkus:quarkus-maven-plugin:1.2.1.Final:create \
    -DprojectGroupId=org.garpesa.services \
    -DprojectArtifactId=second-service \
    -DclassName="org.garpesa.services.consumer.controller.ConsumerController" \
    -Dpath="/consumers" \
    -Dextensions="resteasy-jsonb, hibernate-validator"
```

```
curl -X GET "http://localhost:8082/consumers/message"
curl -X GET "http://localhost:8082/health"
```

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
./mvnw package spring-boot:repackage -DskipTests
java -jar target/cloud-gateway-service-0.0.1-SNAPSHOT.jar
```

```bash
$ curl http://localhost:8080/get
$ curl -f http://localhost:8888/actuator/health

https://hub.docker.com/repository/docker/smartgates/login-mock
curl -v --user root:toor http://localhost:8888/login/authentication
```

https://spring.io/guides/gs/gateway/

https://www.javainuse.com/spring/cloud-gateway



#### docker-compose-healthcheck

https://github.com/peter-evans/docker-compose-healthcheck/blob/master/docker-compose.yml