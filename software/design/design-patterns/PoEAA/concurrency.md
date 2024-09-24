# Concurrency

- from the application to the database(a system transaction)

- from the user to an application (a business transaction)

## Isolation and Immutability

- Concurrency problems occur when more than one active agent has access to the
  same piece of data.

- One way to deal with this is isolation.

- Partition the data so that any piece of it can only be accessed by one active agent

- Processes work like this on OS memory: the OS allocates memory exclusively to
  a single process, and only that process can read/write the data linked to it.

- Isolation is a vital technique because it reduces the chance of errors.

- With isolation you arrange things so that the programs enters an isolated
  zone, within which you don't have to worry about concurrency.

- You only get concurrency problems if the data you're sharing can be modified.

- One way to avoid concerrency conflicts is to recognize immutable data.

## Optimistic and Pessimistic Concurrency Control

- What happens when we have mutable data that we can't isolate?

- Let's suppose two people want to edit a file at the same time

- With optimistic locking both of them can make a copy of the file and edit it freely
  - If A is the first to finish, he can check in his work without trouble
  - The concurrency control kicks in when B tries to commit his changes
  - At this point the source code control system detects a conflict between changes
  - B's commit is rejected and it's up to him to figure out how to deal with it

- With pessimistic locking whoever checks out the file first prevents anyone
  else from editing it.

- Optimistic lock is about conflict detection
- Pessimistic lock is about conflict prevention

## Deadlock

- X has lock on A, Y has lock on B

- X needs lock on B to finish his work (and release lock on A)
- Y needs lock on A to finish his work (and release lock on B)

- Deadlock detection is very difficult and causes pain for victims

- Deadlock detector, for example, pick X and gets back the lock on A, X loses all work

- A similar approach is to give every lock a time limit,

- Timeouts are easier to implement than a deadlock detection mechanism

- If anyone holds a lock for a while might be victimized when there actually is no deadlock present.

- Timeouts and detection deal with a deadlock when it occurs, other approaches
  try to stop deadlocks occurring at all.

- Deadlocks essentially occur when people who already have locks try to get more
  ( or to upgrade from read to write locks)

- One way of preventing deadlocks, is force people to acquire all their locks at
  once at the beginning of their work and then prevent them gaining more.

- You can force an order on how everybody gets locks: always get locks on files
  in alphabetical order. X has lock on Order file, asks lock on Cust file,
  becomes a victim.

- Another technique, if B tries to acquire a lock and A already has one, B
  automatically becomes a victim.
