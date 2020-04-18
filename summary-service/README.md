# summary-service project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `summary-service-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/summary-service-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/summary-service-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide.

```
% mvn quarkus:list-extensions | grep -i hiber
% mvn quarkus:list-extensions | grep -i postgre
% mvn quarkus:list-extensions | grep -i rest
% mvn quarkus:list-extensions | grep -i health

mvn quarkus:add-extension -Dextensions=quarkus-hibernate-orm-panache,quarkus-hibernate-validator,quarkus-jdbc-postgresql,quarkus-resteasy-jsonb,quarkus-smallrye-health

docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 --name quarkus_test -p 5432:5432 -e POSTGRES_USER=sarah -e POSTGRES_PASSWORD=connor -e POSTGRES_DB=statistics -d postgres

% notify mvn package -Pnative
% ls target/*jar

# Create the docker image in the image local repository:
docker build -f src/main/docker/Dockerfile.native -t mgperez/summary-service:native .
docker tag mgperez/summary-service:native mgperez/summary-service:native
% docker images | grep -i mgperez

# Running
% cat /etc/shells
# To change to bash shell
% chsh -s /bin/bash

docker run -i --rm -p 8080:8080 mgperez/summary-service:native
docker run -i --rm -p 8080:8080 -d --name summary-service mgperez/summary-service:native
% docker ps | grep summary
% docker kill summary-service

# To swap back to zsh shell
% chsh -s /bin/zsh
```