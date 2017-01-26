# Performance Tuning

- Dont guess, measure.

## Performance Terminology

- Latency
- Throughput
- Utilization
- Efficiency
- Capacity
- Scalability
- Degradation

### Latency

- End-to-end time taken process a single work-unit at a given workload.

### Throughput

- The number of units of work that a system can perform in some time period with
  given resources.

### Utilization

- Represents the percentage of available resources that are being used to handle
  work unit, instead of housekeeping task or just being idle.

### Efficiency

- Is equal to the throughput divided by the resources used.
- A system that requires more resources to produce same throughput is less efficient.

### Capacity

- Number of work units that can be in flight through the system at any time.

### Scalability

- As resources are added to a system, the throughput (or latency) will change.
- The change in throughput or latency is the scalability of the system,

### Degradation

- If you add more work units, or clients for network systems, without adding
  more resources, typically there will be a change in observed latency or throughput.

- Normally it will be negative degradation, but as work load passes some
  threshold performance can get better. That would be positive degradation.(More
  work unit for parallel processing)

## Measurement

- Codebase gets dirty with the following code
- What happens if method takes under a millisecond to run?
- Cold start effects?

```java
long t0 = System.currentTimeMillis();
methodToBeMeasured();
long t1 = System.currentTimeMillis();
long elapsed = t1 - t0;
System.out.println("methodToBeMeasured took "+ elapsed +" millis"); 
```
There are some tools instrumenting bytecode(adding line before and after
methods).

*NOTE:* Java code start as being interpreted and after some time it switches to
compiled mode. It should be consired when measuring.

* Some of the most important aspects of the platform that contribute to making
  tuning hard are:

1. Thread scheduling
2. Garbage collection
3. JIT compiler


### Hardware Clocks

- RTC(RealTimeClock) is basically same electronics in cheap digital watch.
- RTC is kept powered by motherboard when the system is powered off.
- Also many machines uses NTP(Network Time Protocol) to synchronize to a time server

- TSC(TimeStampCounter), CPU counter that tracks how many cycles the CPU has run.
  Can be affect by power-saving or other runtime factors. 

- HPET(High Precision Event Timers), can be accureate to at least 1 nanosecond.

### Trouble with nanoTime()

- System.currentTimeMillis(): resolution im milliseconds, wall-clock
- System.nanoTime(): May drift away from wall-clock time, sourced from TSC
- nanoTime() can be untrustworthy over long periods of time.
