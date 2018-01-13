# ID Generation Strategies

- If ID generation strategy is not set, by default an AUTO strategy is used,
  Hibernate relies on the database to generate primary keys

- Identity function is provided by some databases including MySQL, DB2

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

### GeneratorType.AUTO

- portable across different DBs
- Hibernate picks an appropriate strategy, asking the SQL dialect of your
  configured DB what is best, it is the default

### GeneratorType.IDENTITY

- provided by some DBs

- Hibernate expects (and create in the table DDL) a special auto-incremented
  primary key column that automatically generates a numeric value on INSERT, in
  the database

### GeneratorType.SEQUENCE

- provided by some DBs

- Hibernate expects (and creates, if you use the tools) a sequence name
  HIBERNATE_SEQUENCE in your DB. The sequence will be called separately before
  every INSERT, producing sequential numeric values.

### GeneratorType.TABLE

- Hibernate will use an extra table in your DB schema that holds the next
  numeric PK value, one row for each entity class.
