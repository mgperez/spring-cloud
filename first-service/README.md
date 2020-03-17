# first-service project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

### Running in dev mode

To develop and run the service continuously in dev mode that enables live coding using:
```
./mvnw compile quarkus:dev -Ddebug=false
```

To build it, use `mvn package`.

### Building and Running

The application is packageable using:

```
./mvnw package -DskipTests
```

It produces the executable `*-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using:

```
java -jar target/*-runner.jar
```

### Testing

```
curl -X GET "http://localhost:8081/employees/message"
curl -X GET "http://localhost:8081/health"
```

### Creating a native executable

You can create a native executable using: 

```
./mvnw package -Pnative
```

Or you can use Docker to build the native executable using:

```
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your binary: `./target/*-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .



### Containerization

The containerization can be done on two ways: as normal JVM based application and as a natively compiled binary. The Dockerfile sources are located in src/main/docker.

Use the following command to build a normal JVM image and run it:

```
docker build -f src/main/docker/Dockerfile.jvm -t mgperez/first-service:jvm .
docker run -i --rm -p 8080:8080 mgperez/first-service:jvm
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
```

And finally, run it with:

```
docker run -i --rm -p 8080:8080 mgperez/first-service:native
```



### Docker Hub

```
docker login
# upload an image
docker push mgperez/first-service:native
```

