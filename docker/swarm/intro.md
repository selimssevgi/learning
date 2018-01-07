# Docker Swarm (Scheduling)

- Docker Machine is a great tool for building and managing machine in a Docker-based fleet

- Docker Compose provides orchestration for Docker container-based services

- The main problems that remain are scheduling containers across a fleet of
  Docker machines and later discovering where those services have been deployed

* "Which machine should I choose to run a given container?"

Major concerns are efficiency of resource usage, the performance characteristics
of each machine's hardware, and network locality. Selecting a machine based on
these concerns is called *scheduling*.

* "Now that my service has been deployed somewhere in my network, how can other services find it?"


- Advertising the availability of a service at a specific location is called *registration*

- Resolving the location of a named service is called *service discovery*

## Building a Swarm cluster with Docker Machine

- A Swarm cluster is made up of two types of machines

- A machine running Swarm in management mode is called a manager

- A machine that runs a Swarm agent is called a node

- Swarm managers and nodes are just like any other Docker machines

- Docker Machine can provision Swarm clusters as easily as standalone Docker machine

- "--swarm", indicates that the machine being created should run the Swarm agent
  software and join a cluster

- "--swarm-master" parameter instructs Docker Machine to configure the new
  machine as a Swarm manager

- Every type of machine in a Swarm cluster requires a way to locate and identify
  the cluster it's joining (or managing)

- "--swarm-discovery" takes an additional argument that specifies the unique
  identifier of the cluster

## Create a Swarm

```shell
docker-machine create --driver virtualbox local
eval "$(docker-machine env local)"

docker run --rm swarm create
# output a hex identifier TOKEN

docker-machine create \
  --driver virtualbox \
  --swarm \
  --swarm-discovery token://TOKEN \
  --swarm-master \
  machine0-manager

docker-machine create \
  --driver virtualbox
  --swarm \
  --swarm-discovery token://TOKEN \
  machine1

docker-machine create \
  --driver virtualbox
  --swarm \
  --swarm-discovery token://TOKEN \
  machine2
```

- These machines can be identified as part of a Swarm cluster in output of ls

- A Docker client could be configured to work with any of these machines individually

- When you configure clients to use the Swarm endpoint on the master, you can
  start working with the cluster like one big machine

- The Swarm API is an extension to the Docker Remote API
- This means that any Docker client can connect directly to a Swarm endpoint and
  treat a cluster as if it were a single machine

- Configure your env to use the Swarm cluster

```shell
eval "$(docker-machine env --swarm machine0-manager)"

docker info

# launch a pull operation on each node
docker pull busybox
```
