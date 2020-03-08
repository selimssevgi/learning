# stateless

- does not maintain state

- a client can't even expect to be interacting with the same session bean
  instance across invocation

- all stateless session bean invocations are atomic

- it is never passivated

- are thread-safe, (not the static fields)

```java
@Stateless(name = "used by jndi binding", mappedName = "used for vendor specific stuff")
```

```java
@EJB
StatelessBean s1;

@EJB
Stateless s2;

s1.equals(s2); // this is required to be true
```

## why not using @Singleton instead?

- all components in Spring are @Singleton by default
- jee container could perform different optimizations in each case
  - that optimization even could be that implementation of stateless would be singleton
  - leaving the choice to the container
