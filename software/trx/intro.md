# transactions

- global vs local trx
- physical vs logical trx


### atomikos

- Log already in use?

```java
// in main class:
System.setProperty("com.atomikos.icatch.log_base_dir", "/tmp/transactions-logs/pocamonscorsvc");
```

- jms listener failed. rollback, possible cause timeout

```java
// in the logs, spring boot listener trx starts/stops in every 30 seconds
default-jta-timeout seems to be 10 seconds for atomikos
set value to 40 seconds to avoid that issue
```

### spring data

- https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#transactions

- SimpleJpaRepository is implementation of CrudRepository/JpaRepository
    - class is @Transactional(readOnly = true)
    - modifying methods are marked as @Transactional
