# Concurreny Keywords

### Critical Section
Only one thread can be progressing through any of an object’s synchronized
blocks or methods at once; if other threads try to enter, they’re suspended by the JVM .
This is true regardless of whether the other thread is trying to enter either the same or
a different synchronized block on the same object. In concurrency theory, this type of
construct is referred to as a critical section.

### Race conditions

### Deadlock
In two thread scenario, each thread requires the other to release the lock it
holds before it releases the lock it has.

One technique to deal with deadlock is to always acquire locks in the same order
in every thread.

- T1: LA, LB; T2: LB, LA. It would cause dead lock.
- T1: LA, LB; T2: LA, LB. Deadlock would be avoided.

### Immutability

- Either have no state or have final fields
- Constructors used to initialize the object
- Always safe and live, so can never be inconsistent state
- Factory methods are common to use with immutable classes
- Constructor with many parameters?
- Use Builder pattern to construct an immutable object

### Stateless
A worker that doesnot keep state internally
(but re-reads it every time it is needed) is called 'stateless'.


### Stale Data/State
Stale state is information in an object that does not reflect reality. Invalid data

Example: an object's members are filled with information from a database,
but the underlying data in the database has changed since the object was filled.

Dangerously stale state is stale state that might adversely affect the operation
of a program, i.e. causing it to perform incorrectly due to invalid assumptions about the data's integrity.

* NON-BLOCKING IO

### Fully synchronized Object/Class

* Safe and live but doesnt have good performance, code is fragile.

- All fields are always initialized to a consistent state in every constructor.
- There are no public fields.
- Object instances are guaranteed to be consistent after returning from any non-
  private method (assuming the state was consistent when the method was called).
- All methods provably terminate in bounded time.
- All methods are synchronized.
- There is no calling of another instance’s methods while in an inconsistent state.
- There is no calling of any non-private method while in an inconsistent state.
