# n+1 Selects Problem

- Lazy loading strategy can result in n+1 selects problem

- Making it EAGER all together may result in other problem: Cartesian product


```java
// 1 query
List<Item> items = em.createQuery("select i from Item i").getResultList();

for (Item item : items) {
   // n queries
   item.getSeller().getUsername(); // each seller must be loaded with an additional SELECT
}
```

- Batch fetching (a blind-guess optimization), batch.size = 10

- (n + 1) / 10, take 10 each time from db instead of 1

- Another optimization could be subselect
