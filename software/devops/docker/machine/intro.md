# Docker Machine (multi-host)

- How can a user launch an environment where different services run on different host?

- How will services in such a distributed environment locate service dependencies?

- How can a user quickly create and manage large sets of Docker hosts in a provider-agnostic way?

- How should services be scaled for availability and failover?

- With services spread all over a set of hosts, how will the system know to
  direct traffic from load balancers?

* Docker Engine and Docker Compose simplify the lives of developers and
  operations personnel by abstracting the host from the contained software.

* Docker Machine and Docker Swarm help system admins and infrastructure
  engineers extend those abstractions into clustered environments.

## Create Docker Hosts

```shell
docker-machine create --driver virtualbox host1
docker-machine create --driver virtualbox host2
docker-machine create --driver virtualbox host3

docker-machine ls
```

- The active machine (indicated with an asterisk under the ACTIVE column) is the
  one that your environment is currently configured to communicate with.

- Any commands issued with the docker or docker-compose CLI will connecti the
  daemon on the active machine


```shell
docker-machine inspect host1
docker-machine ip host1

docker-machine ssh host1

docker-machine scp host1:dog.file host2:dog.file
docker-machine ssh host2 "cat dog.file"

docker-machine stop host2
docker-machine stop host3
docker-machine start host2
docker-machine rm host1 host2 host3
```

## Confugire Docker client to work with remote daemons

- docker or docker-compose are designed to connecto a single Docker host at a time

- One of the most important functions of Docker Machine is producing environment
  configuration for an active Docker host

- In order to active a new machine, you must update your environment

- env subcommand attemps to automatically detect the shell and print the
  commands to configure the environment to connect to a specific machine

```shell
docker-machine env host1

# in case it is not able to detect
docker-machine env --shell powershell host1

# activate host1
eval "$(docker-machine env host1)"

docker-machine active
docker-machine ls

# now docker and docker-compose commands will be run on the active machine
```

```shell
# activate host1
eval "$(docker-machine env host1)"

docker pull nginx:latest

# activate host2
eval "$(docker-machine env host2)"

docker run -d nginx:latest

docker ps -a # shows nginx
eval "$(docker-machine env host1)"
docker ps -a # shows nothing, cus we didnt run any containers on host1

docker-machine rm host1 host2
```
