# Linux namespace and cgroups

- Docker uses Linux namespaces and cgroups, which have been part of Linux since 2007.

## the PID namespace

- Linux provides facilities to create multiple PID namespaces

- Creating a PID namespace for each container is a critical feature of Docker

```shell
docker run -d --name namespaceA busybox /bin/sh -c "sleep 30000"
docker run -d --name namespaceC busybox /bin/sh "nc -l -p 0.0.0.0:80"

# exec is used to run additional processes in a running container
docker exec namespaceA ps
# PID  USER  COMMAND
#   1  root  /bin/sh -c sleep 30000

docker exec namespaceC ps
# PID  USER  COMMAND
#   1  root  /bin/sh -c nc -l -p 0.0.0.0:80
```

```shell
# creating containers without their own PID namespace
docker run --pid host busybox ps
```

## Software Conflict

- Docker container solves such conflicts

```shell
docker run -d --name webConflict nginx
docker exec webConflict nginx -g 'daemon off;' # error! address already in use
```

```shell
docker run -d --name webA nginx
docker run -d --name webB nginx
```

- Two programs want to bind to the same network port
- Two programs use the same temporary filename
- Two programs want to use different version of some globally installed library
- Two copies of the same program want to use the same PID file
- A second program you installed modified an environment variable that another program uses
