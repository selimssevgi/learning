# Why Not Prefer Singleton Pattern

- the singletion pattern is one of the mechanisms people use to make global variables

- In general, global variables are a bad idea for a couple of reasons:

1. Opaicty: it makes harder to reason about the program, it may have unpredicted
   effect on the system

2. testing: we have to set up those global variables for each test case accordinly.

3. not mockable: because it is singletion, it is particularly hard to fake

- static setter: SignletonClass.setTestingInstance(mock)


```java
public void resetForTesting() {
  instance = null;
}
```

- those two options will cause conflict between design goals:
  - make only one instance
  - makes classes testable independently

### why do we want only one instance of a class in a system?

1. we are modeling the real world, and there is only one of these things in the real world.

2. if two of these things are created, we could have a serios problem(two nuclear controls)

3. if someone creates two of these things, we will be using too many resources
