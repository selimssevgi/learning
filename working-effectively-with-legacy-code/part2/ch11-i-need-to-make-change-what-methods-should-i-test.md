# ch11 - i need to make a change. What methods should i test?

### reasoning about effects

- a list passed to a constructor, are there any changes to that list later on
  outside of the class that can class behavior?

- effect diagrams: a buble of a things, and arrow that can affect the buble

* if we make a particular change, how could it possible affect the rest of the results of the program?

- this involves reasoning forward from points of change. When you get a good
  handle on this sort of reasoning, you have the beginnings of a technique for
  finding good places to write tests.

### reasoning forward

- we need to find places to test, and the first step is figuring out where
  change can be detected: what the effects of the change are.

- when we know where we can detect effects, we can pick and choose among them
  when we write our tests

### effect propagation

- effects propagate in code in three basic ways:

1. return values that are used by a caller

2. modification of objects passed as parameters that are used later

3. modification of static or global data that is used later

- in AOP, aspects can affect the behavior of code in other areas of the system
