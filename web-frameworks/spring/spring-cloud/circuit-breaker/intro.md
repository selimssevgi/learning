# Failures in a distributed system

- Cascading failures

- Circuit breaker pattern

* Netflix Hystrix project
- @EnableCircuitBreaker
- @HysrixCommand

* Hystrix Dashboard
- @EnableHystrixDashboard
- Turbine to aggregate Hystrix streams
- @EnableTurbine

## Failure is Inevitable

- Hardware fails
- Network fails
- Software fails

- That chance of failure becomes multiplied in a distributed system

## Cascading Failure

- A failure in a system of interconnected parts in which the failure of a part
  can trigger the failure of successive parts
