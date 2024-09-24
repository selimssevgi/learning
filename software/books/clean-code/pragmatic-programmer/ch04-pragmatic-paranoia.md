# ch04 - pragmatic paranoia

- can't write perfect software

- we drive defensively

- interfacing with other people's code, invalid input etc
- we code defensively, consistency checks, constraints

- pragmatic programmers take this a step further: they don't trust themselves either

- first defensive measure: Design by Contract

- in a world of imperfect systems, ridiculous time scales, laughable tools and
  impossible requirements, let's play it safe

## design by contract

- each party meets its obligations and everyone benefits

- preconditions
  - it is caller's responsibility to satisfy the requirement
  - function should not be called if conditions are not met

- postconditions

- class invariants

- if not practicing DBC, you are back to 'programming by coincidence'

- by expressing the domain of the square root function in the precondition of
  the sqrt routine, you shift the burden of correctness to the caller -- where it belongs

- it is much easier to find and diagnose the problem by crashing early, at the
  site of the problem

## dead programs tell no lies

- crash early

- sometimes it is inappropriate simply to exit a running program
  - releasing resources?
  - writing logs
  - open transactions?

- a dead program normally does a lot less damage than a crippled one

## assertive programming

- if it cannot happen, use assertions to ensure that it wont

- assertions check for things that should never happen

## when to use exceptions

- handle the exception cases in catch block if possible

- dont write if blocks that would look like an arrow

- an exceptions represents an immediate, nonlocal transfer of control, it is a
  kind of cascading *goto*

- prgrams that use exceptions as part of their normal processing suffer from all
  the readability and maintainability problems of classic spaghetti code

- these programs break encapsulation: *!!*
  - routines and their callers are more tightly coupled via exception handling

- register error handler for exceptions/errors

## how to balance resources

- you allocate the resource, use it, and the deallocate it

- finish waht you start

- deallocate resources in the opposite order (orphan resources)
- allocate resources in the same order in different places (avoid deadlock)
