# Design Concepts

- Safety (also known as concurrent type safety)
- Liveness
- Performnace
- Reusability

### Safety

- *Type safety:* An object has methods and usually outside world can use these methods to
  operate on the object, but at the end the object will be in consistent state.

- *Concurrent type safety:* is required when many threads operate on the same
  object on different CPU cores at the same time.(lock and synch?)

### Liveness

- A live system is one in which every attempted activity *eventually* either
  progresses or fails.

##### Transient Failures

- Locking or waiting to acquire a lock
- Waiting for input(such as network IO)
- Temporary failure of a resource
- Not enough CPU time available to run the thread

##### Permanent Failures

- Deadlock
- Unrecoverable resource problem(if the NFS goes away)
- Missed signal


### Design Forces Conflict

- Designing good concurrent systems is difficult, because design forces are
  often in opposition to each other.

* Safety stands in opposition to liveness.(no bad things vs progress)
* Reusability vs safety(exposing internal vs safety)
* Safety vs performance(safe -> heavy use of locks)
