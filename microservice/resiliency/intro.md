# Resiliency

- When it comes to building resilient systems, most software engineers only take
  into account the complete failure of a piece of infrastructure or a key service

- When a service crashes, it's easy to detect that it's no longer there, and the application can route around it

- When a service running slow, detecting that poor performance and routing around it is extremely difficult

*Degradation of a service can start out as intermittent and build momentum*
The degradation might occur only in small bursts. The first signs of failure
might be a small group of users complaining about a problem, until suddenly the
application container exhausts its thread pool and collapses completely


*Calls to remote services are usually synchronous and don't cut short a long-running call*
The caller of a service has no concept of a timeout to keep the service call
from hanging out forever. The application developer calls the service to perform
an action and waits for the service to return

*Applications are often designed to deal with complete failures of remote resources, not partial degradations*
Often, as long as the service has not completely failed, an application will
continue to call the service and won't fail fast. The application will continue
to call the poorly behaving service. The calling application or service may
degrade gracefully or, more likely, crash because of resource exhaustion.

- 'Resource exhaustion' is when a limited resource such as a thread pool or db
  connection maxes out and the calling client must wait for that resource to become available

- Poorly remote service can trigger cascading effect that can ripple throughout an entire application ecosystem

## Client-side resiliency patterns

- The goal of these patterns is to allow the client to "fail fast", not consume
  valuable resources such as database connections and thread pools, and
  preventing problem of remote service from spreading "upstream" to consumers of the client

- There are four client resiliency patterns:

1. Client-side load balancing
2. Circuit breakers
3. Fallbacks
4. Bulkheads

### Client-side load balancing

- Client asks for available service location from service discovery(eureka)

- Caches them on client side, and use Ribbon to decide which instance to be used

- If one of the service instance fails for some reason, the client can remote
  that service from the cache in order not to call it again(eureka built-in)

### Circuit breaker

- In an electrical system, a circuit breaker will detect if too much current is
  flowing through the wire, If the circuit breaker detects a problem, it will
  break the connection with the rest of the electrical system and keep the
  downstream component from being fried

- When a remote service is called, the circuit breaker will monitor the call

- If the calls take too long, the circuit breaker will intercede and kill the call

- If enough calls fail, the circuit breaker will prevent future calls to the failing remote resource

### Fallback processing

- When a remote service call fails, rather than generating an exception, the
  service consumer will execute an alternative code path and try to carry out
  the action through other means

- E-commerce site, call a service to get customized recommendations, if it
  fails, call another service to get more generalized recommendations(diff service)

### Bulkheads

- ship bulkheads

- By using the bulkhead pattern, you can break the calls to remote resources
  into their own thread pools and reduce the risk that a problem with one slow
  remote resource will take down the entire application

- The thread pools acts as the bulkheads for your service

- Each remote resource is segregated and assigned to the thread pool
