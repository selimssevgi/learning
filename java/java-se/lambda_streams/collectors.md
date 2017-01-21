# Collector Notes

### Reduction over Identity

- reduce(int, IntBinaryOperator)
- reduce(T, BinaryOperator) : reduce(BigDecimal.ZERO, BigDecimal::add)
- Works only for immutable objects.

### Reduction to Collection

- Start an empty collection as an accumalator, addAll at the end?
- Reduction over an identity doesnot work with collections at all.
- Reduction *reuses* the identity element. Expects immutability.
- Different threads will accumulate to empty collection(not immutable), it wont
  be empty in other threads. All threads wouldnt be starting with empty
  collections.

- Solution collectors.

## Collectors
- Collectors are generalization of reductions.
- Allow a functional style while continuing to work with a language based on mutation
- Designed for composition
- Flexible and powerful programming tool
- 

* To define a collector, you need to provide:

- Supplier
- Accumulator
- Combiner
- Finisher

## Collectors API
Factory methods in the Collectors class. They produce standalone collectors,
accumulating to:

- framework-supplied containers
- custom collections
- classification maps

## Using Predefined Collectors

- toList(), toSet(), toMap(), joining() [framework provides Supplier]
- toMap(), toCollection() [user provides Supplier]
- groupingBy(), partitioningBy(), groupingByConcurrent() [produce a classification map]


```java
people.stream().collect(Collectors.toSet());
// Collector<Person, ?, Set<Person>)
```

```java
people.stream.collect(Collectors.toMap(Person::getCity, Person::getName));
// Map<City, String> : London -> Bill, Athens -> Amy
// another person: Athens -> John ? IllegalStateException. Collesion.
people.stream.collect(Collectors.toMap(Person::getCity, Person::getName, (a,b) -> a.concat(b)));
// Map<City, String> : London -> Bill, Athens -> Amy + John
```

```java
// user provides supplier
people.stream
      .collect(
       Collectors.toMap(
       Person::getCity,
       Person::getName,
       (a,b) -> a.concat(b),
       TreeMap::new));
```

```java
// collection to custom  collections
NavigableSet<String> sortedNames = people.stream()
   ,map(Person::getName)
   .collect(Collectors.toCollection(TreeSet::new));
```
#### classification map
Like toMap(), except that the values placed in the map are list of elements, one
List corresponding to each classification key:

```java
// Person.getCity() -> Map<City, List<Person>>
Map<City, List<Person>> peopleByCity = people.stream
      .collect(Collectors.groupingBy(Person::getCity));

// into a container defined by downstream Collector
Map<City, List<Person>> peopleByCity = people.stream
            .collect(Collectors.groupingBy(Person::getCity, toSet()));
// Collectors.mapping()

Map<City, String> namesByCity = people.stream()
  .collect(groupingBy(Person::getCity, mapping(Person::getName, joining())))
```

### Concurrent Collection

- Thread-safety is guaranteed by the framework
- Even for non-threadsafe containers.
- What if my container is already threadsafe? (ConcurrentMap)
- Every overload of toMap() and groupingBy() has a dual:
- toConcurrentMap()
- groupingByConcurrent()

# Collectior Examples

```java
// Accumulate names into a List
List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());

// Accumulate names into a TreeSet
Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));

// Convert elements to strings and concatenate them, separated by commas
String joined = things.stream()
                      .map(Object::toString)
                      .collect(Collectors.joining(", "));

// Compute sum of salaries of employee
int total = employees.stream()
                     .collect(Collectors.summingInt(Employee::getSalary)));

// Group employees by department
Map<Department, List<Employee>> byDept
    = employees.stream()
               .collect(Collectors.groupingBy(Employee::getDepartment));

// Multi-level grouping
// Compute sum of salaries by department
Map<Department, Integer> totalByDept
    = employees.stream()
               .collect(Collectors.groupingBy(Employee::getDepartment,
                                              Collectors.summingInt(Employee::getSalary)));

// Partition students into passing and failing
Map<Boolean, List<Student>> passingFailing =
    students.stream()
            .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD))


```
