# Entity and Value Types

- Types are essentially categorized as entity and value types

- Entity types have an identifier and exist on their own, Movie, Car, Student

- Value types do not exist on their own, they are dependent on other objects

* Hibernate provides two categories of value types:

1. Basic Types

- used to map a table column to a Java property

- string, int, long, double fall under this category

2. Components

- a type defined based on more than one field

- PhoneNumber(country_code, region_number, name)

##

A 'User' entity class has 'Address' value type.

- User entity can be saved, load, updated or deleted by its own
- Address is in hands of User
- User instance is fully responsible for the life cycle of the referenced 'Address' instance
- Address instance can't be referenced by anyone else and don't need their own identity
