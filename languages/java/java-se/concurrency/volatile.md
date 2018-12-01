# Volatile keyword

- Since java 1.0
- Used for syncronization of object fields
- Can be used for primities too

1. The value seen by a thread is always reread from main memory before use.
2. Any value written by a thread is always flushed through to main memory before
   the instruction completes.

- Extra flushes on every access
- No locks, no deadlocks with volatile
- Better to use for variables when writing a new value dont depend on the current state(read state)
- If current state matters, use locks.
