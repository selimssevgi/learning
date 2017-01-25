# java.util.concurrent.atomic

- lock-free thread-safe programming on single variables
- Contain several classes that have names starting with 'Atomic'
- Providing same semantics as a volatile in wrapper classes
- Atomic, all-or-nothing
- A simple way to avoid race conditions on shared data
- They can be non-blocking(lock-free)
- A common use is for sequence numbers, getAndIncrement()
- AtomicInt and AtomicLong extend Number class
- Boxed classes and Atomic classes can not replace each other

```java
private final AtomicLong sequenceNum = new AtomicLong(0);

public void nextId() {
  return sequenceNum.getAndIncrement();
}
```
```java
class Sequencer {
  private final AtomicLong sequenceNumber
    = new AtomicLong(0);
  public long next() {
    return sequenceNumber.getAndIncrement();
  }
}
```
