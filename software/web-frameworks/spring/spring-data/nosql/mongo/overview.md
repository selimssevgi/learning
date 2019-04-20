# Spring Data MongoDB

- brings MongoDB to Spring applications in three ways:

1. annotations for object-to-document mapping
2. template-based database access with MongoTemplate
3. automatic runtime repository generation


```java
@Configuration
@EnableMongoRepositories(basePackages = "orders.db")
public class MongoConfig {

  @Bean
  public MongoFactoryBean mongo() { // construct a Mongo instance
    MongoFactoryBean mongo = new MongoFactoryBean();
    mongo.setHost("localhost");
    return mongo;
  }

  @Bean
  public MongoOperations mongoTemplate(Mongo mongo) {
    return new MongoTemplate(mongo, "OrdersDB");
  }
}
```

- even if you never use MongoTemplate directly, you will need this bean because
  the automatically generated repositories will use it under the covers

- rather than declare those bean directly

```java
@Configuration
@EnableMongoRepositories("order.db")
public class MongoConfig extends AbstractMongoConfiguration {

  @Override
  public String getDatabaseName() {
    return "OrdersDB";
  }

  @Override
  public Mongo mongo() throws Exception {
    return new MongoClient();
  }
}
```

### Annotating Models

- JPA has its own mapping annotations

- MongoDB does not have, so Spring Data MongoDB provides annotations for object-to-document mapping

```java
@Document // like @Entity
public class Order {

  @Id
  private String id;

  @Field("client")
  private String customer; // override default field name

  // not referencing another document, it is not nested colleciton inside document itself
  private Collection<Item> items = new LinkedHashSet<>();
}
```

- we dont need to annotate Item, cus it will not be stored as a separate document
- we could use @Field to change how the field is stored

```java
public class Item {
  private Long id;
  private Order order;
  private String product;
  private double price;
  private int quantity;
}
```

### accessing MongoDB

```java
@Repository
public class OrderRepository {

  @Autowired
  MongoOperations mongo; // implementation will be MongoTemplate

  public void operations() {
    Order order = new Order();
    //...
    mongo.save(order, "order");

    Order order = mongo.findById(orderId, Order.class);
  }
}
```

- typically, you would inject MongoOperations into a repository class of your
  own design and use its operations to implement the repository methods

### writing mongoDB repository

- similar to JpaRepository

- MongoRepository also extends Repository interface

```java
public interface OrderRepository extends MongoRepository<Order, String> {}
```

- same method-naming convention works for MongoRepository as well

- @Query also works with MongoRepository except instead of SQL it takes JSON

```java
@Query("{'customer': 'Chuck Wagon', 'type': ?0}") // zeroth parameter
List<Order> findChucksOrders(String t);
```

- custom functionality can me mixed in as well

```java
public interface OrderOperations {
  List<Order> findOrdersByType(String t);
}
```

```java
public class OrderRepositoryImpl implements OrderOperations {

  @Autowired
  private MongoOperations mongo;

  @Override
  public List<Order> findOrdersByType(String t) {
    String type = t.equals("NET")   ? "WEB" : t;

    Criteria where = Criteria.where("type").is(t);
    Query query = Query.query(where);

    return mongo.find(query, Order.class);
  }

}
```

```java
public interface OrderRepository
  extends MongoRepository<Order, String>, OrderOperations {}
```
