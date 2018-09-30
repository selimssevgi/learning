# Garbage Collector Changes

- Removed: GC combinations deprecated in Java 8

- Deprecated: Concurrent Mark Sweep (CMS) collector

## G1 Garbage Collector

- Introduced in JDK 9, now default in JDK 9
- Replaces CMS
- Faster memory management with fewer code tricks
- Trade some throughput for lower latency

- Instead of splitting heap in 3 regions(eden, survivor, old)
- It splits heap in many regions(multiple eden, survivor, old)

- It can work incrementally (Incremental GC)
- Parallel marking
- Designed for large heaps
- Low pause, tuneable pause goal
- Slightly more CPU intensive
