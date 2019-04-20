# Spring Data Neo4j

```java
@Configuration
@EnableNeo4jRepositories(basePackages = "orders.db")
public class Neo4jConfig extends Neo4jConfiguration {

  public Neo4jConfig() {
    setBasePackage("orders"); // models
  }

  @Bean(destroyMethod = "shutdown")
  public GraphDatabaseService graphDatabaseService() {
    return new GraphDatabaseFactory()
                .newEmbeddedDatabase("/tmp/graphdb");
  }
}
```

```java
@NodeEntity
public class Order {

  @GraphId
  private Long id;
  private String customer;

  @RelatedTo(type = "HAS_ITEMS")
  private Collection<Item> items = new LinkedHashSet<>();
}
```

```java
@NodeEntity
public class Item {
  @GraphId
  private Long id;
  private Order order;
  private String product;
  private double price;
  private int quantity;
}
```
