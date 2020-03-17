**Implement Spring Cloud Gateway**



### Bootstrapping

Make sure you have read the prerequisites in https://spring.io/guides/gs/gateway/

https://start.spring.io/

https://spring.io/guides/gs/maven/

https://github.com/spring-guides/gs-gateway

https://www.javainuse.com/spring/cloud-gateway

To run your own gateway use the `spring-cloud-starter-gateway` dependency.

Selected dependencies

- [**Gateway**
  Provides a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as security, monitoring/metrics, and resiliency.](https://start.spring.io/)

### Building and Running

Run the project:

```
./mvnw clean package -DskipTests
./mvnw package spring-boot:repackage -DskipTests
% ls target/*.jar
java -jar target/*.jar
```

### Testing:

```bash
$ curl http://localhost:8888/get
$ curl -f http://localhost:8888/actuator/health
```



### Containerization

https://www.baeldung.com/dockerizing-spring-boot-application

https://github.com/eugenp/tutorials/tree/master/spring-cloud/spring-cloud-config

To create an image from our Dockerfile, we have to run ‘docker build', like before:

```
docker build -f src/main/docker/Dockerfile.jvm -t mgperez/gateway:jvm --rm=true .
% docker images | grep -i mgperez

docker run -i --rm -p 8888:8888 -d --name gateway mgperez/gateway:jvm
% docker ps | grep mgperez
$> docker inspect gateway
$> docker stop gateway
$> docker rm gateway
% docker kill gateway # stop+rm
```

### Docker Hub

https://hub.docker.com/

```
% docker login
docker tag mgperez/gateway:jvm mgperez/gateway:jvm

# upload an image
% docker push mgperez/gateway:jvm
```

https://hub.docker.com/repository/docker/mgperez/gateway/tags?page=1

### Others

https://hub.docker.com/repository/docker/smartgates/login-mock
curl -v --user root:toor http://localhost:8888/login/authentication





