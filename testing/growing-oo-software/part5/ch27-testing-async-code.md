# ch27 - testing asynchronous code

- these tests trigger some activity within the system to run concurrently with the test's thread

```java
// test
// calling an api and processing response async
// assertions
```

- the assertion checks will depend on timings

### sampling or listening

- the test has to wait for the activity to completece successfully and fail if
  this doesn't happen within a given timeout period

- an async test must wait for success and use timeouts to detect failure

- every tested activity must have an *observable* effect

- there are two ways a test can observe the system:
  - by sampling its observable stat (pulling the target system for a system change)
  - by listening for events that it sends out (wake up and check)
