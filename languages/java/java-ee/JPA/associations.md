# Associations

- Associations is used when talking about objects, using fields to represent
  them (Car has a Engine)

- Relationship is used when talking about tables, using PK and FK to represent them

* When talking about associations, there are two things:

1. Multiplicity
2. Directionality

## Multiplicity

- Refers to how many of the specific objects are related to *how many* of the
  other target objects

```shell
Every car has an engine, and each engine belongs to one car.
translates to: "one" car has "one" engine
here the multiplicity is expressed as a one-to-one association
```

```shell
"one" movie consists of "one or more (many)" actors
one-to-many
(actors could be in other movies: many-to-many)
```

```shell
a student can enroll in many(zero or more) courses, while each course can
consist of many students
many-to-many
```

## Directionality

- This property defines the direction to which the association is tending

- The associations can be either unidirectional or bidirectional

```shell
# unidirectional

by querying Car's attribute, we can figure out the engine
(Give me a Car object, will tell you what Engine it has)

Cannot give Car information when having an Engine object

# bidirectional
Car and Owner object. Each would have the reference to the other(one-to-one:bidirectional)
```

```shell
By querying the courses attribute on the Student object, we could tell what
courses he's enrolled in. (many-to-many: bidirectional)
```

