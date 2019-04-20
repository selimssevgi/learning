# Four network container archetypes

- Each server a different purpose, (a different level of isolation)

1. Closed containers
2. Bridged container
3. Joined containers
4. Open containers

## Closed Containers

- No allowence of any network traffic

- Processes inside container have access only to a loopback interface

- Some use cases:
  - volume containers
  - backup jobs
  - offline batch processing
  - diagnostic tools

- A private loopback interface(127.0.0.1)

```shell
# creating a closed container
docker run --rm \
  --net none
  alpine:latest \
  ip addr

# no program running inside that container can reach anything outside the container
docker run --rm \
  --net none \
  alpine \
  ping -w 2 8.8.8.8

# Network is unreachable
```

## Bridged Containers

- Docker creates bridged containers by default

- They relax network isolation, most customizable, should be hardended as a best practice

- They have a private loopback interface and another private interface that's
  connected to the rest of the host through a network bridge

- They can talk to each other and communicate with the larger network through docker0

```shell
docker run --rm \
  --net bridge \  # can be omitted, is default value
  alpine:latest
  ip addr

# list Ehternet interface and a local loopback, and IP address

docker run --rm \
  alpine:latest
  ping -w 2 8.8.8.8 # it works
```

### Opening inbound communication

- Bridge containers aren't accessible from the host network by default

- Containers are protected by your host's firewall system

- The default topology provides no route from the host's external interface to a
  container interface. No way to get to a container from outside the host

- you can create a mapping between a port on the host's network stack and the
  new container's interface

```shell
# binds the container port to a dynamic port on all of the host's interfaces
docker run -p 3333

# binds the speficied container port to the specified port on each of the host's interfaces
docker run -p 3333:3333

# binds the container port to a dynamic port on the interface with the specified IP
docker run -p 192.168.0.32::2222

# hostIP:192.168.0.32
docker run -p 192.168.0.32:1111:2222
```

- For a list of ports

```shell
# images exposes 5000,6000,7000
docker run -d --name dawson \
  -p 5000 \
  -p 6000 \
  -p 7000 \
  dockerinaction/ch5_expose

# the same thing
docker run -d --name dawson \
 -P \                              # expose all relevant ports
 dockerinaction/ch5_expose

# add your own ports to expose
docker run -d --name dawson \
  --expose 8000 \
  -P \                              # expose all relevant ports
  dockerinaction/ch5_expose
```

### Inter-container communication

- All local bridged containers are on the same bridge network and can
  communicate with each other by defalt

- You can configure it to disallow network connections between containers. Doing
  so is a best practice in multi-tenant environments. It minimizes the
  points(called and attact surface) where an attacker might compromise other containers

```shell
docker -d --icc=false ...
```

## Joined containers

```shell
# they share the same network interface
docker run -d --name brady \
  --net none alpine:latest \
  nc -l 127.0.0.1:3333

docker run -it \
  --net container:brady \
  alpine:latest netstat -al
```

## Open Containers

```shell
docker run --rm \
  --net host \
  alpine:latest ip addr
```
