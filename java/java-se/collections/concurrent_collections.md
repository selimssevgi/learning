# Concurrent Collections

- ConcurrentHashMap (Java5)
- CopyOnWriteArrayList (Java5)
- CopyOnWriteArraySet
- BlockingQueue
- Deque (pronounced 'deck'), Java6


## ConcurrentHashMap

- Replacement for synchronized hash-based Map implementations

- Synchronized collections classes hold a lock for the duration of each operation
- Each operation may be calling other methods, take long time, other threads wait

- CHM uses a different locking strategy offering better concurrency and scalability
- Instead of synch every method on a common lock(restricting access to a single
  thread), it uses 'lock striping'

- Provides iterators that do not throw CMException.
- Instead of fail-fast, the iterators returned from CHM are 'weakly-consistent'
- size() and isEmpty() methods are moving target, less important in concurrent
  environment. No guarantees of returning exact values.

- Disadvantage; no client-side locking (synchMap has)

- Additional atomic operations are provided to overcome that disadvantage:

```java
public interface ConcurrentMap<K,V> extends Map<K,V> {
  // Insert into map only if no value is mapped from K
  V putIfAbsent(K key, V value);

  // Remove only if K is mapped to V
  boolean remove(K key, V value);

  // Replace value only if K is mapped to oldValue
  boolean replace(K key, V oldValue, V newValue);

  // Replace value only if K is mapped to some value
  V replace(K key, V newValue);
}
```


## CopyOnWriteArrayList

- Replacement for synchronized List implementations

- Eliminates the need to lock or copy the collection during iteration

- Suitable when iterating is more common than adding

## Blocking Queue

- Blocking put() and take()
- Timed equivalents offer() and pull()
- Queues can be bounded and unbounded
- Blocking queues support 'producer-consumer pattern'
- BlockingQueue simplifies the implementation of P-C design with any number of them

- Two people washing the dishes: producer-consumer design
  - producer person washes the dishes and put them on dish rack
  - If dish rack is full, he has to wait(blocking)
  - consumer person take the dishes from the dish rack and dries them
  - If dish rack is empty, he has to wait(blocking)
  - Dish rack is BlockingQueue

- If producer produce work so much(faster than consuming), memory will fill up
- Bounded Queue will block the producer if queue is full

- Implementation of BlockingQueue
  - LinkedBlockingQueue (LinkedList)
  - ArrayBlockingQueue  (ArrayList)
  - PriorityBlockingQueue
  - SynchronousQueue (no dish rack, handing from p to c, reducing some overhead)

## Deque and BlockingDeque

- Extend Queue and BlockingQueue
- A deque is double-ended queue, allows efficient insertion and removal from head and tail
- Implementations: ArrayDeque and LinkedBlockingDeque
- Work-stealing pattern
