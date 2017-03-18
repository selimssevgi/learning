# Identifiers in Scala

- Scala has very flexible rules for forming identifiers.
- There are four forms of identifier formation.
- Identifiers in programs should not contain '$' character, is reserved for scalac.
- Underscore should be used in identifiers, is always for specials purposes.

## Constants

- X_OFFSET in java
- XOffset in Scala(capitilize, camelcase)

## Alphanumeric Identifier

- Starts with a letter or underscore.

```shell
#legal:   age, salary, _value, __1_value
#illegal: $salary, 123abc, -salary
```

## Operator Identifiers

- Consists of one or more operator characters.
- +, ++, <?>, :::, :->
- :-> is converted into $colon$minus$greater for Java compatibility

## Mixed Identifiers

- Consists of alphanumeric identifiers, which is followed by an underscore and
  an operator identifier.

```scala
unary_-
myvar_=
```

## Literal Indentifiers

- An arbitrary string enclosed in back tick
- Provides possibility to use reserved words as identifiers
- Thread.yield()
- yield is a reserved word in Scala
- Thread.`yield`()
