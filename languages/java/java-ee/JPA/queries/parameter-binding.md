# Parameter Binding

- Do not use string concatenation, cus it opens a hole in query for SQL injections

- Use parameter binding so special characters will be escaped

- there are two approaches to parameter binding:

1. Named Parameters
2. Positional Parameters

## Binding Named Parameters

- use named parameters for cleaner, much safer, and more performant code

```java
Query query = em.createQuery(
  "select i from Item i where i.name = :itemName"
).setParameter("itemName", searchString);
```

## Positional Parameters

- A rarely used and less safe option

- Avoid using positional parameters

- Use CriteriaQuery for more complex queries

```java
Query query = em.createQuery(
  "select i from Item i where i.name like ?1 and i.auctionEnd > ?2"
);

query.setParameter(1, searchString);
query.setParameter(2, tomorrowDate, TemporalType.TIMESTAMP);
```
