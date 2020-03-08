# @PersistenceContext

- takes care of looking up, opening and closing it
- has transaction-scope by default

```java
@PersistenceContext(
  name = "specifies the jndi name of the persistence",
  unitName = "grouping of entities like java packages",
)
```

- if we have a single persistence unit, no need to use attributes, provider will figure it out

- it is good practise to specify the unitName cus spec is not clear on the behavior if one isnt provided
