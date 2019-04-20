# JNDI

### Applications

- resources configured in an application server

- database datasource (especially across multiple environments)


### Naming Service

- meaningful, human-friendly names

- DNS is example of naming service
  - www.google.com  --binding--> 195.122.30.45
  - www.youtube.com --binding--> 195.122.30.46

- DNS has its own naming conventions (reverse order)

- terminology: bind, unbind, rebind

- com has two bindings google, and youtube

### Directory Service

- extension of naming service

- directory service = naming service + attributes

```shell
name1 -----> Directory Object (object1) -----> attr1: value11, value12; att2: value21
```

- phone book is an example of directory service

## JNDI - Java Naming and Directory Interface

- API for Naming and Service services

- jndi architecture

```shell
java app
jdni api
jndi spi (service provider)
ldap, dns, rmi, corba
```

- javax.naming

### Context

- provides operations on a naming service

- is a must-have for working with JNDI

#### lookup

- acceps a name
- returns the object bound to this name

```shell
context.lookup("bob"); // bob instance of User class
```

### bind / unbind / rebind

- acccepts a name and an object

```shell
User newUser = new User("alice");
context.bind("alice", newUser); // throws exception if already bounded

context.rebind("alice", newUser); // updates alice binding

context.unbind("alice");
```

### Example


```java

Context context = new InitialContext();

```
