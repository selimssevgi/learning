# Java 8 (2014)

- Lambda expressions
  - Functional style
  - Behavior parameterisation
- Interface unlocking
  - Static interface methods
  - Default methods(concrete methods)
- Functional Interfaces(@FunctionalInterface)
- Sorting
- Lambda
- String joining
- New Date/Time API
- Metaspace
- Nashorn
- JavaFx
- CompletableFuture

## String joining

```java
List<String> names = Arrays.asList("Selim", "Ahmet", "Mehmet");
// print names in uppercase, comma separated
sout(names.stream().map(String::toUpperCase).collect(joining(", ")));
// Selim, Ahmet, Mehmet
```

## Static interface methods
Instead of creating a separate class to keep static methods, now they can be
place inside the interface itself.(Arrays, Collections)

### Default Methods
All the existing implementations of the interface can benefit the default methods
without requiring to implement one.

!! If there are same default method in the interfaces being implemented, class
has to overwrite that method.

Interfaces cannot have states but have implementation of methods.

## Sorting

- Collections.sort(people)
- people.stream().sorted(comparator)
- comparator: comparing(Person::getAge).thenComparing(Person::getName);
