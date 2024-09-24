# docker container

- it is one of the management commands for container

* run a container

```shell
docker container run --help

docker container run -it busybox

docker container run --detach busybox

docker container run -d --name test busybox

docker container run -it --name test1 busybox echo "Hello"

# overrides the entrypoint command
docker container run --rm -it --name test3 busybox echo "rm container after exit"

docker container run -d --name web \
  -p 8080:8080 \
  -v $(pwd)/webapp.war:/opy/jboss/wildfly/standalone/deployments/webapp.war \
  jboss/wildfly
```

* list containers

```shell
docker container ls # just running containers

docker container ls -a # shows also the ones stopped
```

* remove containers

```shell
docker container rm -vf bb

docker container rm bb2 # removes a stopped container

docker container rm -f bb # remove a running container
```

* check logs

```shell
docker container logs cid

docker container logs -f cid # tail the logs
```
