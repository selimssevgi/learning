# Library Improvements

- String#repeat(int count)
- String#isBlank()
- String#strip()
- String#stripTrailing()
- String#stripLeading()
- String#lines()

```java
"bla".repeat(3);
"   ".isBlank(); // true

"\n\t   text \u2005".strip(); // "text"
"\n\t   text \u2005".trim(); // "text   " ? trim does not know about unicode whitespace

"1\n2\n3\n".lines().forEach(System.out::println);
```

- Files#readString(Path)
- Files#writeString(Path, CharSequence, OpenOption)

- Optional#isEmpty()
- Predicate#not

```java
strings
  .filter(Predicate.not(String::isBlank))
  .forEach(System.out::println);
```
