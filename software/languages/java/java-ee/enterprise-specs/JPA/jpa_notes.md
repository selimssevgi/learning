# JPA Notes

- Java Persistence API

- JSP is the standard in Java for ORM

- The API is designed to build a bridge between Object data in Java, and
  relational data in a database.

- Traditionally has been used with SQL Relational databases.

#### History

- JPA 1.0 - May,2006
- JPA 2.0 - Dec,2009
- JPA 2.1 - Apr,2013

#### JPA 2.1 Implementations:

- Hibernate
- EclipseLink
- DataNucleus

- JPA Entity is just a POJO.

### Entity Manager

- An Entity Manager is the object use to persist/fetch objects from the database.

- EM will handle all the SQL under the covers, and binding of the traditional
  data to the entity object.

### Transactions

- Transactions allow you to rollback or commit.
- This avoids partial transactions being persisted.

### Relationships

- OneToOne, OneToMany, ManyToMany, Embedded

### Data Types

Java | SQL
-----|----
String | VARCHAR(CHAR,VARCHAR2, CLOB, TEXT)
Number, int, long, Float, Double, short, byte | NUMERIC
Boolean | Boolean
Date | TIMESTAMP

### Data Access Objects (DAO) Pattern

### Repository Pattern
