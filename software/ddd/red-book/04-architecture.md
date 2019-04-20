# Architecture

- One of the big advantages of DDD is that it doesnt require the use of any
  specific architecture.

- We use architecture only to mitigate the risk of failure, not to increase our
  risk of failure by using an architectural style or pattern that cannot be
  justified.

1. Layers

2. Hexagonal or Ports and Adapters

3. Service-Oriented

4. Representational State Transfer - REST

5. Command-Query Responsibility Segregation - CQRS

6. Event-Driven Architecture - EDA

7. Data Fabric and Grid Based Distributed Computing

### Layers

- It supports N-tier systems and is commonly used in Web, enterprise, and
  desktop applications.

- UI Layer
- Application Layer
- Domain Layer
- Infrastructure Layer

- 'Strict Layers Architecture' is one that allows coupling only to the layer
  directly below.

- 'Relaxed Layers Architecture', allows any higher-level layer to couple to any
  layer below it.

- The Application Services (Application Layer) are direct clients of the domain
  model, though themselves possessing no business logic. They remain very
  lightweight, coordinating operations performed against domain objects, such as
  Aggregates. They are the primary means of expressing use cases or user stories
  on the model.

** We move the Infrastructure Layer above all others, enabling it to implement
interfaces for all layers below.(when the Dependency Inversion Principle is used)

### Hexagonal or Ports and Adapters

- It advances this goal by allowing many disparate clients to interact with the
  system on equal footing.

- Just add an Adaptor to transform any given client's input into that understood
  by the internal application's API.

- At the same time, output mechanisms employed by system, such as graphics,
  persistence, and messaging, may also be diverse and swappable. That's possible
  because an Adapter is created to transform application results into a form
  accepted by a specific output mechanism.

- HTTP and AMQP Ports

3. Service-Oriented

- 8 service design principles

1. Service Contract

Services express their purpose and capabilities by means of a contract in one or
more description documents.

2. Service Loose Coupling

Services minimize dependency and only have an awareness of each other.

3. Service Abstraction

Services publish only their contract and hide internal logic from clients.

4. Service Reusability

Services can be reused by others in order to build more coarse-grained services.

5. Service Autonomy

Services control their underlying environment and resources to remain
independent, which allows them to remain consistent and reliable.

6. Service Statelessness

Services place the responsibility of state management on consumers, where this
does not conflict with what is controlled for Service Autonomy.

7. Service Discoverability

Services are described with metadata to allow discovery and to make their
Service Contract understood, allowing them to be (re)usable assets.

8. Service Composability

Services may be composed within more coarse-grained services no matter the size
and complexity of the composition they fall within.

### Command-Query Responsibility Segregation - CQRS

- It can be difficult to query from Repositories all the data users need to view

- Collecting data from many Repositories to DTO

- Is there an altogether different way to map domain data to views?

Every method should be either a command that performs an action, or a query that
returns data to the caller, but not both. In other words, asking a question
should not change the answer. More formally, methods should return a value only
if they are referentially transperent and hence possess no side effect.

- At an object level this means:

1. If a method modifies the state of the object, it is a 'command', and its
   method must not return a value. void return type.

2. If a method returns some value, it is a query, and it must not directly or
   indirectly cause the modification of the state of the object.

- It is also known as write(command) and read(query) model.

- An Aggregate without any getter, and Repositories just save() or no
  complecated querying.

- Another model for reading data out of domain.

- As a result, the traditional domain model would be split in two. The command
  model is persisted in one store and the query model in another.

### Event-Driven Architecture - EDA

EDA is a software architecture promoting the production, detection, consumption
of, and reaction to events.

##### Pipes and Filters

```shell
cat phone_numbers.txt | grep 303 | wc -l
```

- A messaging Pipes and Filters approach is not exactly like the command-line
  verison, and it is not intended to be.

- An EDA Filter does not need to actually filter anything. A Filter in an EDA
  may be used to perform some processing while leaving the message data intact.


### Data Fabric and Grid Based Distributed Computing
