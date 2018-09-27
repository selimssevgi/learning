# Garbage Collection

- G1 GC (default since Java 9)

- Several incremental improvements up to Java 11

- Java 11 introduces two new garbage collectors

1. Epsilon GC
2. Z Garbage Collector


## Epsilon GC

- Does not claim memory
- Allocates memory until it runs out of memory
- Useful for apps with predictable, bounded memory usage

- No garbage-collector paradigm also applies to very "short-lived" programs
- For example, a command line program

- Can be used during performance testing without non-deterministic influence of GC

```shell
-XX:+UnlockExperimentalVMOptions
-XX:+UseEpsilonGC
```

## Z GC

- Pause times under 10 ms(shorter than most other GCs)
- No pause time increase with heap size increase(constant pause time)
- Scale to multi-terabyte heaps

#### Coloured pointers

- Every object on JVM referenced by a 64-bit pointer
- Z GC reserves 4 bits on each pointer that points to objects in the heap to
  record GC status information on this object(less bits available for actual address)

- Linux/x64 only

```shell
-XX:+UnlockExperimentalVMOptions
-XX:+UseZGC
```
