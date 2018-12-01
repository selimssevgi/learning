# Classloader Delegation

- There are usually more than one classloader

- There is a hierarchy of classloader

- Class loader **may** delegate to its parent
  - delegation is the default behavior of built-in class loaders
  - if you write your own, you could decide not to delegate

- Parent may load class
  - parent does not have to load the class
  - if a classloader loads a class once, it must load it in the future
  - Classloaders load the class once, it is cached (singleton)


### Classloading in Basic Java App

- three classloaders will be in play

3. Bootstrap class loader(written in C)

2. Extension class loader

1. Application class loader (loads app classes and local ones)

- JVM asks ACL,
- ACL delegates to ECL
- ECL delegates to BCL

- if none of them finds the class, delegates back to down, finallly exception.
