# Typed Query

- getSingleResult returns Object type, has to be cast

- You can skip the cast when creating a TypedQuery

```java
Query query = em.createQuery("select i from Todo i where i.id = :id");
Todo t = (Todo) query.setParameter("id", 1)getSingleResult();

TypedQuery<Todo> typedQuery =
    em.createQuery("select i from Todo i where i.id = :id", Todo.class);
Todo t2 = typedQuery.setParameter("id", 1).getSingleResult();
```
