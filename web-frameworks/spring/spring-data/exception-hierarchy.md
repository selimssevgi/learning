# Spring's data-access exception hierarchy

- JDBC has SQLException for everything (too generic)
- need to catch and dig into exception to know what went wrong
  - the application is unable to connect to db
  - the query has syntax errors
  - tables or columns do not exist
  - constraint violation

- SQLException is checked and mostly when it caught there is nothing much to do about it



- Hibernate offers different exceptions, each targeting a specific data-access problem
- can have specific catch blocks
- but those exceptions are specific to Hibernate


* we need a hierarchy of data-access exceptions that are descriptive but not
  directly associated with a specific persistence framework

- Spring's exception hierarchy is far richer than JDBC's simple SQLException, it
  is not associated with any particular persistence solution

- The root exception in the Spring is DataAccessException, which is
  RuntimeException
