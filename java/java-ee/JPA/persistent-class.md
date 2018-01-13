# Persistent Class

- The class may implements java.io.Serializable, though is not an requirement

- The class can be abstract

- May extend a non-persistent class or implement an interface

- Must be a top-level class, not nested within another class

- The persistent-capable class and any of its methods can't be *final* (a
  requirement of JPA specification)

- Hibernate and JPA require a constructor with no arguments for every persistent class
