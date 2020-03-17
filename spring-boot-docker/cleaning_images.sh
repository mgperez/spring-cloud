#!/bin/bash
# https://gist.github.com/bastman/5b57ddb3c11942094f8d0a97d461b430
# https://linuxize.com/post/how-to-remove-docker-images-containers-volumes-and-networks/

# To remove all docker containers based on servidor:latest
# docker ps -a | awk '{ print $1,$2 }' | grep servidor | awk '{print $1 }' | xargs -I {} docker rm -f {}

# Delete all images
# docker rmi $(docker images -q)

#$ docker images
docker rmi $(docker images --filter "dangling=true" -q --no-trunc)

#$ docker images | grep "smart"
docker rmi -f $(docker images | grep "smart" | awk '/ / { print $3 }')

docker rmi -f $(docker images | grep "mgperez" | awk '/ / { print $3 }')