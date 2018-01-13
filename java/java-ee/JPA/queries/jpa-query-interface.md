# JPA Query Interfaces


```java
Query query = em.createQuery("select i from Todo i");
```

## getResultList()

```java
Query query = em.createQuery("select i from Item i");
List<Item> items = query.getResultList();

// scalar result
Query query = em.createQuery("select i.name from Item i");
List<String> itemNames = query.getResultList();
```

## getSingleResult()


```java
TypedQuery<Item> query = em.createQuery(
  "select i from Item i where i.id = :id", Item.class
).setParameter("id", ITEM_ID);

Item item = query.getSingleResult();
```

- If there are no results, throws a NoResultException
- force you to guard instead of returning null

```java
try {
  TypedQuery<Item> query = em.createQuery(
    "select i from Item i where i.id = :id", Item.class
  ).setParameter("id", NON_EXISTINT_ID);

  Item item = query.getSingleResult();
} catch (NoResultException ex) {
  //
}
```

- if there is more than one result, throws a NonUniqueResultException

```java
try {
  Query query = em.createQuery(
    "select i from Item where name like '%a%'"
  );

  Item item = (Item) query.getSingleResult();
} catch (NonUniqueResultException ex) {
  //
}
```
