# New Trends in Concurrency

- there are problems with threads and locks

- there most popular trends in implementing concurrent applications:

## Software transactional memory (STM)

- STM is a concurrency control mechanism similar to database transactions

- Instead of working with tables and rows, STM controls the access to shared memory

- An STM transaction executes a piece of code that reads and writes a shared memory

- This is typically implemented in a lock-free way and is composable

## Dataflow concurrency

- share variables across multiple tasks or threads

- these variables can only be assigned a value once in its lifetime

- the values from these variables can be read multiple times

- they can be read even when the value isn't assigned to the variable

- more deterministic programs with no race conditions and deterministic deadlocks

## Message-passing concurrency

- components communicate by sending messages

- messages can be sent both syncly and asyncly

- asynchronously sending messages to other components is more common

- these messages are immutable and arae separated from the state of individual components

- message-passing concurrency encourages share nothing architecture

- the most successful implementation of MPC is the actor model

- it became popular after Erlang demonstrated the success of using the actor
  model as a concurrency model for building large-scale, distributed, parallel telecom applications
