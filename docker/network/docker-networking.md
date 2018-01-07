# Docker container networking

- Docker is concerned with two types of networking:

1. Single-host virtual networks

2. Multi-host networks

## Local Docker network topology

- Containers have their own private loopback interface and a separate Ethernet
  interface linked to another virtual interface in the host's namespace

- These two linked interfaces form a link between the host's network stack and
  the stack created for each container

- It is like typical home networks, each container is assigned a unique private
  IP address that's not directly reachable from the external network

- Connections are routed through the Docker bridge interface called docker0

- docker0 interface is like your home router

- Each of the virtual interfaces created for containers in linked to docker0,
  and together they form a network

- The bridge interface is attached to the network where the host is attached

- Docker uses kernel namespaces to create those private virtual interfaces, but
  the namespace itself doesn't provide the network isolation
