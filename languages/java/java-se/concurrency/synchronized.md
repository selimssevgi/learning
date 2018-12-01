# Synchronized

- Only objects—not primitives—can be locked.

- Locking an array of objects doesn’t lock the individual objects.

- A synchronized method can be thought of as equivalent to a synchronized
(this) { ... } block that covers the entire method (but note that they’re repre-
sented differently in bytecode).

- A static synchronized method locks the Class object, because there’s no
instance object to lock.

- If you need to lock a class object, consider carefully whether you need to do so
explicitly, or by using getClass() , because the behavior of the two approaches
will be different in a subclass.

- Synchronization in an inner class is independent of the outer class (to see why
this is so, remember how inner classes are implemented).
synchronized doesn’t form part of the method signature, so it can’t appear on
a method declaration in an interface.

- Unsynchronized methods don’t look at or care about the state of any locks, and
they can progress while synchronized methods are running.

- Java’s locks are reentrant. That means a thread holding a lock that encounters a
synchronization point for the same lock (such as a synchronized method calling
another synchronized method in the same class) will be allowed to continue. }

##### Why synchronized but not locked or something else?

- What is being synchronized?
- The memory representation in different threads of the object being locked is
  what is being synchronized.

- After synchronized block or method has completed, any and all changes that
  were made to the object being locked are flushed back to main memory before
  the lock is released.

- When a synchronized block is entered, then after the lock has been acquired.
  any changes to the locked object are read in from main memory, so the thread
  with the lock is synchronized to main memory's view of the object before the
  code in the locked section begins to execute.
