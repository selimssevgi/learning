# stateful beans

- unlike stateless session beans, this guarantees that a client can expect to
  set the internal state of a bean and count on the state being maintained
  between any number of method calls

- same client is routed to the same bean on each invocation in a given time period

- phone switchboard: same customer agent answers your call if you call more than once in a given time period

- the only real difference with stateless counterpart is that how container manages their lifecycle
  - each call from the same client goes to the same bean

- only one thread is accessing the bean at a time

- *passivation* used for optimization

- are ideal for multistep, workflow-oriented business process


```java
@Stateful
public class DefaultOrderProcessor implements OrderProcessor {}
```

```java
@EJB
DefaultOrderProcessor d1;

@EJB
DefaultOrderProcessor d2;

d1.equals(d2); // this is required to be false
```

### clustering

- ejb spec does not require it

- most app servers cluster stateful session beans

- the state of the bean is replicated across all machines participating in the application server cluster

- even if the machine with your bean crashes, a clustered, load-balanced, and
  failed-over set of servers means that you will be transparently rerouted to
  the next available machine on the cluster

### lifecycle

- container creates bean instance

- after the contruction is done, container injects other beans and resources

- instance is in memory waiting for method invocation

- a client executes a business method

- the container waits for subsequent method invocations

- if the client remains idle for a period of time, the container passivates the bean instance
  - container supports passivation
  - bean is serialized
  - from memory to disk

- if the client invokes a passivated bean, it is activated

- if the client doesnt invoke a method on the bean for a period of time, the bean is destroyed

- if the client requests removal of a bean instance and is presently passivated,
  it will be activated and then the bean will be destroyed and GCed

*NOTE:* a method can be annotated both @PostConstruct and @PostActivate, or
@PreDestroy and @PrePassivate
