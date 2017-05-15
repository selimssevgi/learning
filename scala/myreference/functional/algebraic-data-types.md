# Algebraic Data Types

- Just as algebra is fundamental to the whole of mathematics, algebraic DTs are
  fundamental to many common functional programming languages

- "algebraic data type" in FP languages is better called "systematic composite data type system"

- in Python, there are int long float string dict list etc. These are built-in types

- The idea of algebraic DT is that, start with a set of primitive types, and
  write code to create composite types

- In this way types are well controlled and systematically extensible

## Algebra

1. a set of objects
2. the operations - used on those objects to create new objects from that same set
3. laws

### Numeric Algebra
1. numbers (could be natural, rational, real or complex)
2. operations (addition or multiplication)

### Relational Algebra

1. the set of relations (table as in db)
2. operations: projection, selection, joining, renaming

## Product Type

- a product type, or a record type, or a tuple type
- in oop: composition
- from pre-existing type Float, a new type called Pair is created
- a pair has x AND y values

```scala
class Pair(val x: Float, val y: Float)
```

## Sum Type

- a sum type, or a variant type, or a discreminated union
- oop: sub-typing which allows you to generate a new type from another via 'extension'
- it is has x OR y, not both at the same time

## Counting Inhabitants

- Counting the number of inhabitants (values) of a given type

* There are 0 ways to construct Nothing
* Unit has 1 inhabitant: ()
* Boolean has 2.
* 'Either a b' has as many as a and b, combined. a + b
* (a, b) has an inhabitant for each combination of a's and b's: a x b
* a -> b has b^a inhabitants
