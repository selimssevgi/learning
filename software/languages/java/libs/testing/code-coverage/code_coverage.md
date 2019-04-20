# Code Coverage

- Is a measurement of percentage of instructions of code being executed while
  the automated tests are running.
- Is more important to have meaningful unit tests than having %100 code coverage.


- Code Coverage Metrics:

1. Statement or line coverage
2. Branch coverage
3. Function or method coverage

* Java code coverage tools can be categorized in two sections:

1. tools that instrument the source code(easy, requires recompilation)
2. tools that instrument the bytecode(complicated, not require recompilation)

- Cubertura: bytecode, GNU     PL, easy to configure, widely used
- EMMA     : bytecode, Common  PL,
- JaCoCo   : bytecode, Eclipse PL, on the fly, replacement of EMMA
- Clover   : source code, Atlassion

- They have Gradle, Maven and IDE plugins.
