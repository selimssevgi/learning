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

## from Misko Hevery

You can live in a society where everyone (every class) declares who their friends
(collaborators) are. If I know that Joe knows Mary but neither Mary nor Joe knows Tim,
then it is safe for me to assume that if I give some information to Joe he may give it to Mary,
but under no circumstances will Tim get hold of it. Now, imagine that everyone (every
class) declares some of their friends (collaborators), but other friends (collaborators which
are singletons) are kept secret. Now you are left wondering how in the world did Tim got
hold of the information you gave to Joe.

Here is the interesting part. If you are the person who built the relationships (code)
originally, you know the true dependencies, but anyone who comes after you is baffled, since
the friends which are declared are not the sole friends of objects, and information flows in
some secret paths which are not clear to you. You live in a society full of liars.
