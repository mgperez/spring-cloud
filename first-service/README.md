# Implement First Microservice

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

### Bootstrapping

Make sure you have read the prerequisites in https://quarkus.io/guides/getting-started-guide

https://code.quarkus.io/

tar -xvf first-service.zip

- RESTEasy JSON-B:  Java API for JSON Binding (JSR 367: JSON-B API) serialization support for RESTEasy
- Hibernate Validator: Validate data coming to your REST endpoints

### Extensions

```
mvn quarkus:list-extensions

mvn quarkus:add-extension -Dextensions="io.quarkus:quarkus-smallrye-health"
mvn quarkus:add-extension -Dextensions="io.quarkus:quarkus-smallrye-openapi"
```

### Running in dev mode

To develop and run the service continuously in dev mode that enables live coding using:
```
./mvnw compile quarkus:dev -Ddebug=false
# stop/terminate
Ctrl+C
```

To build it, use `mvn package`.

### Building and Running

The application is packageable using:

```
./mvnw clean package -DskipTests
% ls target/*-runner.jar
```

It produces the executable `*-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using:

```
java -jar target/*-runner.jar
```

### Testing

```
curl -X GET "http://localhost:8080/employees/message"
curl -X GET "http://localhost:8080/health"
```

### Creating a native executable

You can create a native executable using: 

```
./mvnw package -Pnative
```

Or you can use Docker to build the native executable using:

```
./mvnw package -Pnative -Dquarkus.native.container-build=true

# to build in a container it is recommended you add these to your application.properties so you do not need to specify them every time.
quarkus.native.container-build=true
quarkus.native.container-runtime=docker
```

You can then execute your binary: `./target/*-runner`

```
% ls target/*-runner
```

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .

### Containerization

The containerization can be done on two ways: as normal JVM based application and as a natively compiled binary. The Dockerfile sources are located in src/main/docker.

Use the following command to build a normal JVM image and run it:

```
docker build -f src/main/docker/Dockerfile.jvm -t mgperez/first-service:jvm .
docker tag mgperez/first-service:jvm mgperez/first-service:jvm
% docker images | grep -i mgperez

docker run -i --rm -p 8080:8080 -d --name first-service mgperez/first-service:jvm
% docker ps | grep first
% docker kill first-service
```

To build the native binary image and make it even smaller, use a Quarkus distroless base image. Use the following Dockerfile and put it into src/main/docker/Dockerfile.native.

Then use the following command to build the native image and run it:

[For more info](https://quarkus.io/guides/building-native-image#creating-a-container)

```
# Maven build to produce an executable from inside a container:
./mvnw package -Pnative -Dnative-image.docker-build=true

mvn package -Pnative -Dquarkus.native.container-build=true
docker-compose up --build

# Execute Docker
mvn package -Pnative -Dquarkus.native.container-runtime=docker

# to build in a container it is recommended you add these to your application.properties so you do not need to specify them every time.
quarkus.native.container-build=true
quarkus.native.container-runtime=docker
```

Then, if you didn’t delete the generated native executable, you can build the docker image with:

```
# Create the docker image in the image local repository:
docker build -f src/main/docker/Dockerfile.native -t mgperez/first-service:native .
docker tag mgperez/first-service:native mgperez/first-service:native
% docker images | grep -i mgperez
```

And finally, run it with:

https://linuxize.com/post/docker-run-command/

```
docker run -i --rm -p 8080:8080 -d --name first-service mgperez/first-service:native
% docker ps | grep first
% docker kill first-service
```

### Docker Hub

https://hub.docker.com/

```
% docker login
docker tag mgperez/first-service:native mgperez/first-service:native
docker tag mgperez/first-service:jvm mgperez/first-service:jvm
# upload an image
% docker push mgperez/first-service:native
% docker push mgperez/first-service:jvm
```

https://hub.docker.com/repository/docker/mgperez/first-service/tags?page=1