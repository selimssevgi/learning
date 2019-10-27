# Persistence Layer

- Although JPA already provides a certain level of abstraction, there are
  several reasons you should considier hiding JPA calls behind a facade:

* A custom persistence layer can provide a higher level of abstraction for
  data-access operations. Instead of basic CRUD and query operations as exposed
  by the EntityManager, you can expose higher-level operations, such as
  getMaximumBid(Item i) and findItems(User soldBy) methods. This abstraction is
  the primary reason to create a persistence layer in larger applications: to
  support reuse of the same data-access operations

* The persistence layer can have a generic interface without exposing
  implementation details. In other words, you can hide the fact that you're
  using Hibernate(or JPA) to implement the data-access operations from any
  client of persistence layer.

* We can use JPA or JDBC in our implementation for mixed data-access code, in
  this way in addition to portability, it helps unifying data-access ops as well

## A generic data access object pattern

- The basic instance-storage and -retrieval operations are grouped in a generic
  super-interface and a superclass that implements these operation.

- The generic interface is extended by interfaces for particular entities that
  require additional business-related data-access operations.

```java
public interface GenericDAO<T, ID> {
  T findById(ID id);
  T findReferenceById(ID id);
  List<T> findAll();
  Long getCount();
  // state-managing interface methods
  T makePersistence(T entity);
  void makeTransient(T entity);
}

public class GenericDAOImpl
```
