# Java Memory Model(JMM)

- *Happens-Before:* This relations indicates that one block of code fully
  completes before the other can start.

- *Synchronizes-With:* This means that an action will synchronize its view of an
  object with main memory before continuing.

- Happens-Before and Synchronizes-With could be thought as basic conceptual
  building blocks for understanding Java concurrency.

* JMM has these main rules:

- An unlock operation on a monitor Synchronizes-With later lock operations.
- A write to a volatile variable Synchronized-With later reads of the variable.
- If an action A Synchronizes-With action B, then A Happens-Before B.
- If A comes before B in program order, within a thread, then A Happens-Before B.
