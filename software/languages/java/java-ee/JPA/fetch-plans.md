# Lazy and Eager Loading

- Every association and collection should be loaded on demand, lazily.
  - This default fetch plan most likely result in many SQL statement
  - Each loading only one small piece of data, (n+1 selects problem)

- The alternative fetch plan, using eager loading,
  - will result in fewer SQL statement
  - larger chunks of data are loaded into memory with each SQL query
  - you might see the 'Cartesian product problems', as SQL result sets become too large

## Entity Proxies

- Entity class cant be final, cus Hibernate generate proxy subclass in runtime

- For some reason, they must have public or protected no-arg constructor

- Proxies enable lazy loading of entity instances

```java
Item item = em.getReference(Item.class, ITEM_ID); // no select, returns a proxy
item.getId(); // doesnot trigger initialization
item.getName(); // triggers initialization
```
