# What is cache?

- Data structure holding a temporary copy of some data

- Trade off between higher memory usage for reduced latency

- Targets:

1. Data which is reused

2. Data which is expensive to compute or retrieve

** There are only two hard things in Computer Science: cache invalidation and
naming things. (Phil Karlton)

## Desired cache features

- Capacity control / eviction

- Data freshness / expiry

- Data consistency / invalidation

- Fault tolerant (app should even work without cache)
