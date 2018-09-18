# Circuit Breaker Pattern

* Learn to embrace failure:

- Tolerate failures
- Gracefully degrade(do not call failed service, fail fast, old data, or empty)

* Limit resources consumed

- Constrain usage: clients should put limits on the number of resources allowed
  to call a dependent service. It prevents those requests from stacking up
  unconstrained, which could cause the client to fail itself.


- CBP: a design pattern in modern software development used to detect failures
  and encapsulates logic of preventing a failure to reoccur constantly

- Prevents real circuits to get on fire when detecting so much flow going
  through and opening the circuit.
