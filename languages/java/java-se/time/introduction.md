# java.time

- comes with java 8

- replaces:
  - java.util.Date
  - java.util.Calendar
  - java.util.TimeZone
  - java.util.DateFormat

- no need to use Joda-Time

- built from scratch, but inspired by Joda-Time

- open source project - JSR-310


### goals

- comprehensive model for date and time
- supporting commonly used global calendars
- immutable to work well with lambdas/functional

- type-safe
  - avoid primitives where sensible
  - self-documenting
  - IDE friendly

- interoperate with existing classes

- integration of xml and databases

### design principles

- immutable
  - thread-safe, allows caching

- fluent
  - easy to read, like a sentence

- clear, explicit, expected
  - methods well defined, simple javadoc
  - strong control over state

- extensible
  - JSR/JDK authors dont know everything
