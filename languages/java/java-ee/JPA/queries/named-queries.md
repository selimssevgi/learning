# Named Query

- Embedded query string literals isn't unreasonable for simple queries, but when
  you begin considering complex queries that must be split over multiple lines,
  it gets a bit unwieldly

- You can give eaci query a name and move it into annotations or XML files

- Externalizing queries is often preferred in larger applications; hundreds of
  queries are easier to maintain in a few well-known places rather than
  scattered throughout the code base in various classes accessing the db

## Calling a named Query

- named queries are global in a persistence unit

```java
Query query = em.createNamedQuery("findItems");

// or typed
TypedQuery<Item> tq = em.createNamedQuery("findItemById", Item.class);
```

## Defining queries with Annotations

- @NamedQuery and @NamedNativeQuery

- Can be only placed on a mapped class

- JPA annotations cannot be put into a package-info.java metadata file

```java
@NamedQueries({
        @NamedQuery(
                name = "findTodoById",
                query = "select t from Todo t where t.id = :id"
        )
})

@Entity
//...
```

## Defining named queries programmatically

- EntityManagerFactory#addNamedQuery()

- You register your queries once, on startup of your application 
```java
Query findTodosQuery = em.createQuery("select t from Todo t");

em.getEntityManagerFactory().addNamedQuery(
  "savedFindTodosQuery", findTodosQuery
);

Query query = em.createNamedQuery("savedFindTodosQuery");
```
