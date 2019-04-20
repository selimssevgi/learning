# Spring Data Repositories Deep Dive

- Repository implementations come from SimpleJpaRepository
- Uses the default ones from super class
- Derive the implementation for custom methods

- Re-declare methods to customize
  - return types
  - annotation config (tx, locking)

### Repository interface

- Limit the methods on the repository
- Here the repository will not have delete, find etc.

```java
// Repository interface is marker, has no methods
public CustomerRepository extends Repository<Customer, Long> {
  Customer save(Customer customer);
}
```

### CrudRepository interface

- you may start to add the methods for simple crud operation
- at that point you can just use CrudRepository

```java
public CustomerRepository extends CrudRepository<Customer, Long> {
  // it already has methods covering most of the uses cases
}
```

### PagingAndSortingRepository interface

- adds pagination and sorting methods to CrudRepository

```java
findAll(Sort sort);

findAll(Pageable pageable);
```

### JpaRepository interface

- specific to jpa stores
- extends PagingAndSorting

- adds batching operations

## Custom read-only Repository

- we can define our own repository methods
- for example to have only read-only methods

- could be useful if there will be more than one read-only repository


```java
@NoRepositoryBean // intruct spring-context not to create a bean from this
public interface ReadOnlyRepository<T> extends Repository<T, Long> {
  // copy read-only methods from other repositories
  T findOne(Long id);

  boolean exists(Long id);

  List<T> findAll();
}

public interface ProductRepository extends ReadOnlyRepository<Product> {
  Page<Product> findByDescriptionContaining(String description, Pageable pageable);
}
```

## Manually Defined Queries


```java
@Query("select p from Product p where p.attributes[?1] = ?2")
List<Product> findByAttributeAndValue(String attribute, String value);
```

## Provide custom implementation

- We can provide the implementation of one of the methods in the repository
