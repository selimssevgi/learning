# Docker Compose (multi-container)

- is a tool for defining, launching, and managing services, where a 'service' is
  defined as one or more replicas of a Docker container

- Services and systems of services are defined in YAML files

- You can use simple commands to accomplish these tasks:
  - Build Docker images
  - Launch containerized applications as services
  - Launch full systems of services
  - Manage the state of individual services in a system
  - Scale services up or down
  - View logs for the collection of containers making a service


```yml
# /tmp/wp-example/docker-compose.yml
wordpress:
  image: wordpress:4.2.2
  links:
    - db:mysql
  ports:
    - 8080:80

db:
  image: mariadb
  environment:
    MYSQL_ROOT_PASSWORD: example
```

```shell
# /tmp/wp-example
docker-compose up

docker ps
docker-compose ps # includes only the list of containers defined by *.yml file

# clean up
docker-compose rm # all services in *.yml file, -f does not work with this
docker-compose stop
docker-compose kill
docker-compose rm -v # after stopping services, do not leave volumes behind
```

```shell
docker-compose up -d # launch container in the detached mode, no log output

docker logs acontainer # doesnot scale well if need to check more containers

docker-compose logs [container1] [container2] # aggregated logs

docker build # build any artifacts defined in yml file
```
