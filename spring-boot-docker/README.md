### Dockerize Dependent Applications in a Composite

```
# Then run:
% docker-compose config

# Removing volume 
docker-compose down -v

% docker-compose build
% docker-compose up -d

# (default: docker-compose.yml)
docker-compose up -d --build

% docker-compose ps

$>../postgre/
$ docker-compose -f docker-compose.postgre.yml config
$ docker-compose -f docker-compose.postgre.yml up -d
$ docker-compose -f docker-compose.postgre.yml ps
$ docker-compose -f docker-compose.postgre.yml down -v

Clean container
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
docker rmi $(docker images -q -f dangling=true)
```

