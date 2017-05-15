# Dataflow

- Dataflow concurreny is a deterministic concurrency model

- if it works, it will always work without deadlock

- if it deadlocks the first time, it will always deadlock

- this guarantee is important in concurrency

- dataflow allows you to write seq code that performs parallel operations

- the limitation is that the code should be completely side-effect free

- cannot have deterministic behavior if code is performing side-effecting ops
