# Service Discovery

- Eureka client and server
- Configuration
- Health & High Availabiity
- Dashboard

## What is it? Why need it?

- Individually deployed services
- How does one service locate another?
- Simple configuration file?
- what if two instances of service? Update configuration file each time?
- Do not forget instances come and go in response to demand
- What if an instance fail?

- Service Discovery provides:

* A way for a service to register itself
* A way for a service to deregister itself
* A way for a client to find other services
* A way to check the health of a service and remote unhealthy instances

## Discover services with:

- Spring Cloud Consul
- Spring Cloud Zookeeper
- Spring Cloud Netflix
