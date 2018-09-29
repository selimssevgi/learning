# Serial and Parallel Garbage Collectors

- Serial generational collector: -XX:+UseSerialGC

- Parallel for young, serial for old generation: -XX:+UseParallelGC

- Parallel young and old space generational collector: -XX:UseParallelOldGC

- Concurrent mark sweep with serial young space collector:
  - -XX:+UseConcMarkSweepGC
  - -XX:+UseParNewGC

- Concurrent mark sweep with with parallel young space collector
  - -XX:+UseConcMarkSweepGC
  - -XX:+UseParNewGC

- G1 garbage collector: -XX:+UseG1GC


## Serial Collector

- Single threaded
- Stop the world
- Mark and sweep
- OK for small applications running on the client

## Parallel Collector

- Multiple threads for minor collection
- Single thread for major collection
- Same process as Serial
- Use on servers

## Parallel Old Collector

- Multiple threads for minor and major collections
- Preferred over ParallelGC

## Concurrent Mark and Sweep (CMS)

- Only collects old space
- No longer 'bump the pointer' allocation
- Causes heap fragmentation
- Designed to be lower latency
