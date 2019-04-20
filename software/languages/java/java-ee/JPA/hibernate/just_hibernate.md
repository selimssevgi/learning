# Notes from Just Hibernate

## Chapter 1 - Basics

- Object-relational impedance mismatch:

1. Inheritance is the fundamental OOP principle without which object
   associations would be impossible to design. Databases do not understand
   inheritance.

2. When it comes to the rich set of object associations like one-to-one,
   one-to-many, many-to-many, databases fall flat, as they cannot support all
   types of relationships.

3. Lastly, there is also an identity mismatch: objects carry both an identity
   and equality, while database records are identified with their column values.

JDBC is good for small projects, developer has to write and manually do most of
the work. When project gets bigger, things get out of the way. This is where
Hibernate came into picture.


#### SessionFactory

- is a thread-safe global factory class for creating Sessions.
- is defined for one, and only one, database.
- The goal of SessionFactory is to create Session objects.
- maintains a second level of cache globally.
- Configuration(xml) -> SessionFactory -> Session

#### Session
- is not thread-safe and should not be shared across different classes.
- A gateway to our database.
- Takes care of all db operations such as saving, loading, retrieving records.
- first level cache.

#### Transactions

- keep our work segregated from other
- synchronize with durable storage to avoid incorrect data being R/W
- 4 fundamental properties: atomicity, consistency, isolation, durability(ACID)


#### HibernateException
- unchecked RuntimeException

## Chapter 2 - Fundamentals

#### Object-Relational Mismatch

- Domain model
- Domain objects: a bank account, book search

- Databases store data in 2D format: rows and columns
- Domain objects hold state using attributes(variables)
- Domain objects cannot be stores in databases as is. At a very high level, this
  mismatch is called *object-relational impedance mismatch*.

* A Few Fundamental Differences:

1. *Inheritance Mismatch*: Object world supports, relational schemas do not.

2. *Identity Mismatch*: identical(==), equal(.equals) but relational schema has
   just id(primary) to identify rows.

3. *Relations and Associations Mistmatch*: In java objects could have different
   associations(one2one, one2many, many2many), relational schemas support to
   some extends. not impossible but tedious task.

For above 3 reasons, ORM tools came out. They were developed to automate the
object-relational persistence strategies.

#### Hibernate's Main Parts

1. Persistent class(POJOs and AJOs[Annotated java objects])
2. Configuration and mapping definitions(XML or Annotations)
3. Access and manipulation of the data using the API

## Chapter 3 - Annotations


## Chapter 4 - Persisting Collections

- Always use interfaces when you are defining your collection variables.
  Hibernate does not like it when we use concrete classes as the variable types.
  The reason is that HB uses its own implementation behind the scene.

```java
List<String> actors = new ArrayList<>();
```
