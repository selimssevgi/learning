# ch07 - It takes forever to make a change

### understanding

- complex, no structural code base

### lag time

- is the amount of time that passes between a change that you make and the
  moment that you get real feedback about the change.



- Spirit on Mars, it takes 7 mins for a signal from Earth to reach. Send it
  signal, and 14 minutes later see where it moved. Then send another signal.

- if we  conpress the time between steps down from a minute to a few seconds,
  the quality of the mental work becomes different.

- we can use feedback to try out approaches quickly, our work becomes more like
  driving than like waiting at a bus stop.

### Breaking Dependencies

- as we break dependencies and section off classes into new packages or
  libraries, the overall cost of a rebuild of the entire system grows, but the
  average time for a build can decrease.

** DI Principle **

When your code depens on an interface, that dependency is usually very minor and
unobstrusive. Your code doesn't have to change unless the interface changes.

It is better to depend on interfaces or abstract classes then it is to depend on
concrete classes. When you depend on less volatile things, you minimize the
change that particular changes will trigger massive recompilation.
