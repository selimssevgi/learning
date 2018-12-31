# JdbcTemplate

- JdbcOperations is an interface defining operations implemented by JdbcTemplate

```java
@Bean
public JdbcTemplate jdbcTemplate(DataSource dataSource) {
  return JdbcTemplate(dataSource);
}
```

```java
@Repository
public class JdbcRepository implements MyRepository {
  private JdbcOperations jdbcOperations;

  @Inject
  private JdbcRepository(JdbcOperations jdbcOperations) {
    this.jdbcOperations = jdbcOperations;
  }
}
```

- jdbcOperations.update
- jdbcOperations.queryForObject
