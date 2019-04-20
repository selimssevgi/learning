# Netflix Hystrix

- Is a latency and fault tolerance library designed to stop cascading failure
  and enable resilience in complex distributed systems where failure is inevitable.

- Implements the circuit breaker pattern

* Wraps calls and watches for failures
  - 10 sec rolling window
  - 20 request volume
  - >= 50% error rate

- Waits & tries a single request after 5 sec

- It will give a change to execute 'fallback' for failed requests

- Protects services from being overloaded 
  - thread pools, semaphores, & cascading failures 

## Usage in Spring Boot

- 'start-hystrix'
- @EnableCircuitBreaker
- @HystrixCommand(fallbackMethod = "fallbackMethodName")
