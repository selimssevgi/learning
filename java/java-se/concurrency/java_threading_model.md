# Java Threading Model

- Based on two fundamental concepts:

1. Shared, visible-by-default mutable state
2. Preemptive thread scheduling

- Some important aspects of these ideas:

1. Objects can be easily shared between all threads within a process.
2. Objects can be mutated(changed) by any threads that have a reference to them.
3. The thread scheduler can swap threads on and off cores at any time, more or less.
4. Methods must be able to be swapped out while they are running(infinite loop method could steal CPU forever)

Item 4 causes:
- unpredictable swaps, half-done methods, inconsistent state. visibility to other threads

Item 5 solves with:
5. Objects can be locked to protect vulnerable data
