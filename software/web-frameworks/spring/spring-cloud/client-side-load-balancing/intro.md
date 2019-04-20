# Intro to Client Side Load Balancing

- Load balancing improves the distribution of workloads across multiple
  computing resources.

- What is the role of load balancing in a cloud-native architecture?

- Multiple Services vs Multiple Instances

- From multiple instances with a single load balancer
- To multiple services and multiple instances with multiple load balancers

## Different Types of Load Balancing

- Server-side: server is responsible for the distribution of the load
  - hardware or software based
  - extra hop (intermediatry request)
  - occurs outside of the request process
  - centralized or distributed

- Client-side: client is responsible
  - software based
  - no extra hops
  - occurs within of the request process
  - typically distributed

* Client-side load balancing is a natural fit for cloud native architectures.
