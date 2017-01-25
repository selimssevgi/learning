# Locks

- java.util.concurrent.locks

### Problems with lock in synchronized

- There is only one type of lock
- It applies equally to all synchronized operations on the locked object
- The lock is acquired at the start of the synchronized block or method
- The lock is released at the end of the block or method
- The lock is either acquired or the thread blocks, no other outcome are possible

### 

- Different types of locks(such as reader and writer locks)
- No restrict locks to blocks(allow a lock in one method and unlock in another)
- If a thread cannot acquire a lock(another thread has it), allow thread to back
  out and carry on or do smth else(tryLock())
- Allow a thread to attempt to acquire a lock and give up after a certain amount
  of time.

## Lock Interface

Implementations:

- ReentrantLock(slightly flexible usual lock)
- ReantrantReadWriteLock(many readers few writers)
