#### Dockerizing a Spring Boot Application

https://www.baeldung.com/dockerizing-spring-boot-application

2. Common Base Image

To finally build the image and store it in the local library, we have to run:

NOTICE: The –tag option will give the image its name and –rm=true will remove intermediate images after it has been built successfully. The last character in this shell command is a dot, acting as a build-directory argument.

```
docker build --tag=mgperez/alpine-java:base --rm=true .
% docker images | grep alpine-java
```

NOTICE: The –tag option will give the image its name and –rm=true will remove intermediate images after it has been built successfully. The last character in this shell command is a dot, acting as a build-directory argument.

### Docker Hub

https://hub.docker.com/

```
% docker login
docker tag mgperez/alpine-java:base mgperez/alpine-java:base

# upload an image
% docker push mgperez/alpine-java:base
```



3. Dockerize a Standalone Spring Boot Application

As a preparation-step, we have to assemble a runnable jar file

https://github.com/eugenp/tutorials/tree/master/spring-cloud/spring-cloud-config

```
tutorials $> cd spring-cloud-config/server
server    $> mvn package spring-boot:repackage
```

To create an image from our Dockerfile, we have to run ‘docker build', like before:

```
docker build --file=Dockerfile.server \
     --tag=config-server:latest --rm=true .
$> docker images | grep config
```

But before we're going to run a container from our image, we have to create a volume for mounting:

Managing Docker Volumes On Windows

https://www.youtube.com/watch?v=jTeDNXLFYjE

Docker - Crear imágenes y manejo de volúmenes

https://www.youtube.com/watch?v=5vENgNBphzQ

```
docker volume create --name=spring-cloud-config-repo
$> docker volume ls | grep spring
```

NOTICE: While a container is immutable, when not committed to an image after application exits, data stored in a volume will be persistent over several containers.

Finally we are able to run the container from our image:

Some more useful options:
-it – enable interactive mode and allocate a pseudo-tty
-d – detach from the container after booting

```
docker run --name=config-server --publish=8888:8888 \
     --volume=spring-cloud-config-repo:/var/lib/spring-cloud/config-repo \
     config-server:latest
     
$> docker inspect config-server
$> docker stop config-server
$> docker rm config-server
```

```
docker build --file=Dockerfile.client \
     --tag=config-client:latest --rm=true .
$> docker images | grep config
```



4. Dockerize Dependent Applications in a Composite

```
docker-compose config
docker-compose up --build -d
docker-compose ps
docker-compose down
docker rmi $(docker images -q -f dangling=true)
```

