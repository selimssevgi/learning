# Custom Queries

- query methods have their limits
- sometimes it is not convenient or even possible to express the query in a method name


```java
@Query("select i from Item i where i.email like '%gmail.com%'")
List<Item> findAllGmailItems();
```
