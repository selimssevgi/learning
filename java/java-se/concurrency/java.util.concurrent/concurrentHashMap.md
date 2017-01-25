# ConcurrentHashMap

- java.util.concurrent
- Implements ConcurrentMap interface
- It provides additional multithreaded safety and higher performance
- It is an improvement on the syncronizedMap() (Collections class)

- A well-written implementation of a concurrent HashMap will be essentially
  lock-free on reads, and for writes will only lock the bucket being modified.
