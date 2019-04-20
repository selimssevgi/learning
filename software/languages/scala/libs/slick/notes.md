# Slick

- Scala Language Integrated Connection Kit
- Database query and access library for Scala
- Successor of ScalaQuery

## Components

- Lifted Embedding
- Direct Embedding
- Plain SQL
- Session Management
- Schema Model

## Compared to ORMs

* Impedance Mismatch:

- Mapping low-level programming (OOP) to high-level concepts(releational
  algebra)

- Not transparent (but pretends to be)

* Better Match: Functional Programming

- Relation  -> case class Coffee(name: String, supplierId: Int, price: Double)
- Attribute -> supplierId
- Tuple     -> coffee("Colombian", 101, 7.99)
- Relation Value
- Relation Variable

* Functional-Relational Mapping

- Embraces the relational model
- No impedance mismatch
- Composable Queries
- Explicit control over statement execution
- Stateless
