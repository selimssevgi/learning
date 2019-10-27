# CriteriaBuilder and CriteriaQuery


```java
//JPA.getEntityManager().getCriteriaBuilder();
CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Object> criteria = cb.createQuery();
criteria.select(criteria.from(Todo.class));
em.createQuery(criteria);
```
