# Service Discovery

- In any distributed architecture, we need to find the physical address of where a machine is located

- Service discovery can be smth as simple as maintaining a property file with
  the addresses of all the remote services, or smth formalized as a UUDI

- Service discovery is critical to microservice, cloud-based applications.

* Two reasons why it is critical:

1. Consumer does not know the physical address of their services, they find them
with help of service discovery. This gives us the possibility of add/remote
instances from the pool

2. It helps increase application resiliency. Service discovery engine can remove
   the unhealthy instances from the pool

* Can't we use tried-and-true methods such as DNS or a load balancer in
  microservice-based environment?

- The number of the application servers are not static

- The application servers are not persistent

- The application servers do not have the same IP after restart

** Single point of failure: load balancers are centralized, is down, everything is down

** Limited horizontal scalability: primary and secondary load balancer, no more

** Statically managed: traditional load balancers aren't designed for rapid
registration and de-registration of services

## Service discovery in the cloud

** Highly available: service lookups can be shared across multiple nodes in a
service discovery cluster, if a node is down, other nodes should take over

** Peer-to-peer: each node in the service discovery cluster shares the state of a service instance

** Load balanced: dynamically load balance requests across all service instances

** Resilient: The service discovery's client should "cache" service information
locally. If service discovery is down, client can still operate using local cache

** Fault-tolerant: Service discovery needs to detect when a service instance
isn't healthy and remove the instance from the list of available services that
can client requests. It should detect these faults with services and take action
without human intervention
