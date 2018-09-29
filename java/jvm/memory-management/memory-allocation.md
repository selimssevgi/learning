# Memory Allocation

- Want memory allocation to be as quick as possible
  - Can simply increment a pointer
  - Young always uses this, old may use it

- Simpliest way of doing this is to use pointer arithmatic

- Have pointer pointing to the beginning of a heap
- When allocating an object, it is allocated at the pointer
- Then our pointer is simply moved to next free space in the heap
- Moving the pointer is very very cheap

* Above approach is fine for a single-thread environment
* What happens in a multi-threaded environment?

- Two pointers both competing for the same piece of memory at the same time
- This involves locks and locks are expensive

* Java uses Thread Local Allocation Buffers(TLABs)
* Each thread gets its own buffer in the Eden space
* Threads can only allocate into their buffer
* No locking required
