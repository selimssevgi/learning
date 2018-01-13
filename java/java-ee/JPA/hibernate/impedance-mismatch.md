# Object-relational impedance mismatch

* Inheritance is the fudamental OOP principle without which object associations
  would be impossible to design. Databases do not understand inheritance.

* When it comes to the rich set of object associations like one-to-one,
  one-to-many, and many-to-many, databases fall flat, as they cannot support all
  types of relationships.

* There is also an identity mismatch; objects carry both an identity and
  equality, while database records are identified with their column values.

## Inheritance Mismatch

- There is no easy way to map inheritance hierarchy in database table (Is-A)

- Has-A relations are expressed in the database

## Identity Mismatch

- To overcome the identity and equality feature deficiencies, DBs tend to employ
  'primary key' strategies

```java
ClassA objectA = new ClassA();
ClassA objectB = objectA;

objectA == objectB; // same memory location, identical

objectA.equals(objectB); // true if they are equal
```

## Relations and Associations Mismatch

- Associations in programming languages are supported by relational databases to
  some extent. The foreign key referring to a primary key is the way of
  expressing associations in a relational schema

  - one-to-one
  - one-to-many
  - many-to-many
