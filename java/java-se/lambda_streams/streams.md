# Stream Notes

- BaseStream <- Stream, IntStream, LongStream, DoubleStream
- Telling what to do not how to do

- A sequence of elements
- No storage(unlike Collections, Arrays)
- Pipeline pattern
- Free parallelisation out of the box
- A new java.util.stream package

- *Non-interference:* Streams are expected to be immutable, otherwise it rise exception.

## Stream vs Collection

* Collections
  - Data structures
  - Since beginning of Java
  - Storage is primary
  - Insertion and removal contracts
  - External iteration strategy
  - Finite data
  - Calculations on data before insertion

* Streams
  - Sequence of data
  - New in Java 8
  - No storage
  - Internal iteration strategy
  - Infinite data
  - Dynamic computations

## Streams Pipeline

[DataSource] --> Intermediate Op1 --> Intermediate Op2 --> Terminator

## Stream Methods

*Intermediate Operations:*
- Always lazy

*Intermediate:stateful Operations:*
- may incorporate previously seen elements when processing new elements.

- Stream distinct() : removes duplicates
- Stream skip(long n) : skips first n elements

- ?Stream limit(long maxSize) : .limit(3)

*Intermediate:stateless Operations:*
- retain no state from previously seen element when processing new element
- each element can be processed independently of operations on other elements

- Stream filter(Predicate predicate) : .filter(u -> u.getAge > 18)
- Stream map(Function mapper) : .map(User::getName)

*Terminal Operations*

- Produce a result or a side-effect
- Stream pipeline is considered consumed, create a new stream
- are eager,(except iterator() and spliterator())

- long count() : terminal operation
- collect(Collectors.toList()) : toSet(), toMap(keyMapper, valueMapper)
- Optional reduce(BinaryOperator) : reduce(Integer::sum), reduce((a,b) -> a + "," + b)
- T reduce(T, BinaryOperator) : int total = stream.reduce(10, (i,j) -> i + j)
- forEach(System.out::println)

*Short-circuiting terminal operations:*

- Optional findFirst()
- Optional findAny()   : same as findFirst, just better to use with parallelism
- boolean  anyMatch(Predicate)
- boolean  allMatch(Predicate) : if all elements matches, true if stream is empty
- boolean noneMatch(Predicate)

## Creating Streams

- From collection : Collection.stream();
- From arrays     : Arrays.stream(Object[] o);
- Stream.of(T... values);
- Stream.of(T t), IntStream.range(int,int)
- Generating : generate(), iterate()
- BufferedReader.lines()
- Random.ints()

```java
Stream<String> emptyStream = Stream.empty();
System.out.println(emptyStream.count()); // 0

Stream<String> names = Stream.of("Selim", "Ahmet");
System.out.println(names.count()); // 2

String[] arr = {"Selim", "Ahmet"};
Stream<String> names2 = Stream.of(arr);
System.out.println(names2.count()); // 2

Stream<Double> s = Stream.generate(Math::random);
Stream<Integer> intStream = Stream.iterate(1, i -> i + 1);
Stream<String> lines = Files.lines(Paths.get("/a/file/path"));
```

## Iterating Strategies

- Internal and External iteration strategies

```java
// External
for(Movie movie : movies) {
  if (movie.isClassic()) {
    System.out.println(movie);
  }
}

// Internal
movies.stream().
.filter(Movie::isClassic)
.map(Movie::getName)
.forEach(System.out::println);
```

## Lazy and Eager Operations

- Intermediate operation - lazy - returns Stream
- Terminal     operation - eager- returns result

## Primitive Streams

- for int, long, double.
- Avoid boxing cost

```java
int[] ints = {1,2,3,4};
IntStream intStream1 = IntStream.of(ints);

double[] doubles = {1.0, 2.0, 3.0};
DoubleStream doubleStream = DoubleStream.of(doubles);

// convertion
users.stream().mapToInt(User::getAge).sum();
```
