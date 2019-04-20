# Native Query

- If you need to use features specific to your db product, your only choice is
  native SQL

```java
Query query1 = em.createNativeQuery("select * from todos", Todo.class);
```
