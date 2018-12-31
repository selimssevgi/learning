# Notes on Repositories

- Create an interface extending generic JpaRepository
- Supply entity type and id type as generic parameters
- Annotate with @Repository

```java
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
```


```java
//main
ApplicationContext ctx = SpringApplication.run(SpringBootDataApplication.class, args);
BookRepository repository = ctx.getBean(BookRepository.class);
Book book = new Book();
book.setTitle("A test Book");
book.setPageCount(200);
book.setPublishDate(new Date());
repository.save(book);
```

## Repository Hierarchy

- They are generic interfaces: \<T, ID\> : T: Entity Type, ID: Id Type
- interface Repository : a marker interface
- interface CrudRepository extends Repository
- interface PagingAndSortingRepository extends CrudRepository
- interface JpaRepository extends PagingAndSortingRepository


```java
# 
Book book = repository.findOne(1L);
List<Book> books = repository.findAll();
List<Book> someBooks = repository.findAll(Arrays.asList(1L, 3L, 7L));

List<Book> randomBooks = BookUtil.create(5);
repository.add(randomBooks);

// update: knows there is already a book with that ID
book.setTitle("War and Peace");
repository.save(book);

repository.delete(1L);
repository.delete(repository.findOne(2L));
repository.delete(Arrays.asList(1L, 3L, 7L));
repository.deleteInBatch(Arrays.asList(1L, 3L, 7L)); // in one sql statement
repository.deleteAll();
repository.deleteAllInBatch(); // where id=? or id=? or id=?

// Paging
// result size: 3, page: 0(index 0)
repository.findAll(new PageRequest(0,3)).forEach(System.out::println);

// Sorting
// default: asc
repository.findAll(new Sort(Sort.Directon.DESC, "pageCount")).forEach(System.out::println);
```

## Limiting Repository Operations

- Spring creates bean for interfaces extending Repository. 
- Disable this annotate interface with @NoRepositoryBean.

```java
@NoRepositoryBean
public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T, ID> {
  T findOne(ID id);
  Iterable<T> findAll();
}
```

## Derived Queries

- Creates queries based on method signitures.

```java
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  // String Operators
  Book findByTitle(String title);
  // System.out.println(repository.findByTitle("War and Peace"));

  List<Book> findByTitleLike(String title);
  // repository.findByTitleLike("%of%").forEach(System.out::println);

  List<Book> findByTitleContaining(String title);
  // repository.findByTitleContaining("of").forEach(System.out::println);

  List<Book> findByTitleStartingWith(String title);
  // repository.findByTitleStartingWith("O").forEach(System.out::println);

  List<Book> findByTitleEndingWith(String title);
  // repository.findByTitleEndingWith("s").forEach(System.out::println);

  List<Book> findByTitleIgnoreCase(String title);
  // repository.findByTitleIgnoreCase("ANimal FARM").forEach(System.out::println);
  

  // Relational Operators
  // for fields implementing Comparable interface
  List<Book> findByPageCountEquals(int pageCount);
  List<Book> findByPageCountGreaterThan(int pageCount);
  List<Book> findByPageCountLessThan(int pageCount);
  List<Book> findByPageCountGreaterThanEqual(int pageCount);
  List<Book> findByPageCountLessThanEqual(int pageCount);
  List<Book> findByPageCountBetween(int min, int max);

  // Logical Operations
  List<Book> findByTitleContainingOrTitleContaining(String title, String title2);
  List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);
  List<Book> findByTitleNot(String title);

  // Date Comparisons
  // Date date = new SimpleDateFormat("MM/dd/yyyy").parse("10/22/1955");
  List<Book> findByPublishDateAfter(Date date);
  List<Book> findByPublishDateBefore(Date date);
  List<Book> findByPublishDateBetween(Date start, Date end);

  // Ordering Results
  List<Book> findByTitleContainingOrderByTitleAsc(String title);
  List<Book> findByTitleContainingOrderByTitleDesc(String title);

  // Limiting Query Results Top=First
  List<Book> findTopByOrderByPageCountDesc();
  List<Book> findFirstByOrderByPageCountAsc();
  List<Book> findTop5ByOrderByPriceDesc();
  List<Book> findTop5ByTitleByOrderByPriceDesc();

  // Paging custom query
  List<Book> findTop5ByTitleByOrderByPriceDesc(Pageable pageable);
```

## @Query Annotation

- When interface method signatures are not enough.
```java
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  @Query("select b from Book b")
  List<Book> queryOne();

  @Query("select b from Book b where b.pageCount > ?1")
  List<Book> queryTwo(int pageCount);

  @Query("select b from Book b where b.title = :title")
  List<Book> queryThree(@Param("title") String title);
}
```

## @NamedQuery

- It is defined in entity class file.
- It is jpa annotation.
- Name must be in the form EntityName.InterfaceMethod

```java
@Entity
@Table(name = "BOOK")
@NamedQuery(name="Book.queryOne, query="select b from Book b")
@NamedQuery(name="Book.queryTwo, query="select b from Book b where b.pageCount > ?1")
@NamedQuery(name="Book.queryThree", query="select b from Book b where b.title = :title")
public class Book {}
```
