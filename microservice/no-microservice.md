# When not to use microservices

1. Complexity building distributed systems
2. Virtual server/container sprawl
3. Application type
4. Data transactions and consistency

## Compexity of building distributed systems

- Microservices are distributed and fine-grained (small)

- They introduce a level of complexity into your application

- Microservice architecture require a high degree of operational maturity

- Don't consider using microservices unless the organization is willing to
  invest in the automation and operational work that a highly distributed
  application needs to be successful

## Server sprawl

- A microservice instance deployed to one server

- In large microservers-based application, the number of server/containers can be high

- The operational complexity of having to manage and monitor these servers can be tremendous

## Application Type

- Microservices are geared toward reusability and are extremely useful for
  building large applications that need to be highly resilient and scalable

- If you are building small, department-level applications with a small user
  base, complexity might be more expense then it's worth

## Data transformations and consistency

- If your applications need to do complex data aggregation or transformation
  across multiple sources of data, the distributed nature of microservices will
  make this work difficult

- No standard exists for performing transactions across microservices

- Microservices can communicate amongst themselves by using messages

- Messaging introduces latency in data updates

- Your applications need to handle eventual consistency where updates that are
  applied to your data might not immediately appear
