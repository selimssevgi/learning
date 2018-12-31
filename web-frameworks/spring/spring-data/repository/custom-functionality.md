# Custom Functionality

- at some point we may want functionality in the repository that can't be
  described with Spring Data's method-naming conventions or even with a @Query

- when we need to do smth that Spring Data JPA can't do, we will have to work
  with JPA at a lower level than Spring Data JPA offers

- we dont have give up on all goodies to have our own custom functionality

- when SDJPA generates the implementation for a repository interface, it also
  looks for a class whose name is the same as the interface's name postfixed with 'Impl'

- ItemRepository -> ItemRepositoryImpl


```java
public interface SpitterSweeper {
  int eliteSweep();
}

public class SpitterRepositoryImpl implements SpitterSweeper {

  @PersistenceContext
  private EntityManager em;

  public int eliteSweep() {
    String update =
      "UPDATE Spitter spitter " +
      "SET spitter.status = 'Elite' " +
      "WHERE spitter.status = 'Newbie' " +
      "AND spitter.id IN (" +
      "SELECT s FROM spitter s WHERE (" +
      " SELECT COUNT(spittles) FROM s.spittles spittles) < 10000" +
      ")";
    return em.createQuery(update).executeUpdate();
  }
}
```

```java
public interface ItemRepository
  extends JpaRepository<Item, Long>, SpitterSweeper {}
```
