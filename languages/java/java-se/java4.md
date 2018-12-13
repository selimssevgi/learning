# Java 1.4 (2002)

- NIO(nonblocking io)
- Assertions
- Pattern and Matcher classes

## StrackTraceElement

- Throwable had supported printing of stack traces.

- in the past, programmers would turn printing into call stack introspection by
  capturing the output of 'printStackTrace', parsing it, and making it available
  programmatically.

- JDK 1.4 alleviates the need for such solutions by including StackTraceElement
  objects that can be obtained from a Throwable
