# Hibernate Query Language


```sql
SELECT * FROM movies; -- sql, uses table name
FROM movies;          -- hql, uses entity name
```

```java
Session session = sessionFactory.getSession();

Query query = session.createQuery("from Movie");

Query query = session.createQuery("from Movie where title IN (:titlelist)");

query.setMaxResults(100);
query.setFirstResult(10); // built-in pagination
```

```java
Session session = sessionFactory.getSession();
Query query = session.createQuery("from Movie where runtime='150'"); 
query.uniqueResult();
```

## Named Queries

```java
Query query = session.createQuery("from Movie where runtime=:runtime");

query.setString("runtime", runtime);
```

## Positional Parameters

- Deprecated, use named Queries

```java
Query query = session.createQuery("from Movie where title=? and id=?");

query.setString(0, "ABC");
query.setInteger(1, 5);
```
