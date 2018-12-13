# ch03 - sensing and separation

- to write the test we need to create the object.
- if it has lots of dependencies that will be cumbursome and not effective.

- we often have to break dependencies to get classes into a test harness, but
  that isn't the only reason to break dependencies.

- we want to get tests in place, there are two reasons to break dependencies: sensing and separation

1. sensing: we break deps to sense when we can't access values our code computes

2. separation: we break deps to separate when we can't even get a piece of code
   into a test harness to run.



- fake objects as collabrators (fake implementation of interface)
- mock objects are fakes that perform assertions internally.
