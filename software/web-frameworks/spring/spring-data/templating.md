# Templating data access

- a template method defines the skeleton of a process

- the process itself is fixed; it never changes

- at certain points, the process delegates its work to a subclass to fill in
  some implementation-specific details

- different implementations of this interface define specific implementations of this portion of process

- the is the same pattern that Spring applies to data access

- no matter what technology you are using, certain data-access steps are required
  - obtain a connection
  - clean up resource

- spring separates the fixed and variable parts of the data-access process into two distinct classes:

```shell
1. prepare resources
2. start transaction
3. execute in transaction
4. return data
5. commit/rollback transaction
6. close resources and handle errors
```

1. templates (1, 2, 5, 6)
2. callbacks (3, 4)

template class | used to template
----------------------------------------------------------------------
CciTemplate
JdbcTemplate
NamedParameterJdbcTemplate | support for named parameters
SimpleJdBcTemplate         | deprecated in 3.1
HibernateTemplate          | hibernate 3.x+ sessions
SqlMapClientTemplate       | iBATIS SqlMap clients
JdoTemplate                | java data object implementations
JpaTemplate                | jpa entity managers
