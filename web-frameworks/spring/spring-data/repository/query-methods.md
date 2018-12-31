# Query Methods

- Repository methods are composed of (findByUsername)
  - a verb (find)
  - an optional subject (isn't specified, implied by T)
  - the word By
  - and a predicate (Username)

- Spring Data allows for four verbs: get, read, find, count
- get, read, find verbs are synonymous

- the subject of a repository method is optional
- its primary purpose is to allow you some flexibility in how you name the method
  - findUsersByFirstnameOrLastName()
  - findByFirstnameOrLastName()
  - findThoseThingsWeWantByFirstnameOrLastname()

- subject is ignored for the most part
- there is an exception to that rule, if the subject starts with the word 'Distinct'

### Predicate

- each condition must reference a property and may also specify a comparation operation

- if the comparison operator is left off, it is implied to be an equals operation


```shell
IsAfter, After, IsGreaterThan, GreaterThan
IsBefore, Before, IsLessThan, LessThan
IsLessThanEqual, LessThanEqual
IsBetween, Between
IsNull, Null
IsNotNull, NotNull
IsIn, In
IsNotIn, NotIn
IsStartingWith, StartingWith, StartsWith
IsEndingWith, EndingWith, EndsWith
IsContaining, Containing, Contains
IsLike, Like
IsNotLike, NotLike
IsTrue, True
IsFalse, False
Is, Equals
IsNot, Not
```

```java
List<Item> findByFirstnameIgnoringCaseOrLastnameIgnoresCase(String f, Stirng l);
List<Item> findByFirstnameOrLastnameAllIgnoresCase(String f, Stirng l);
```

### Order

- OrderBy

```java
List<Item> findByFirstnameOrLastnameOrderByLastnameAsc(String f, Stirng l);

List<Item> findByFirstnameOrLastnameOrderByLastnameAscFirstnameDesc(String f, Stirng l);
```
