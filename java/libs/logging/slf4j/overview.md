# SLF4J

- is an abstract layer for logging API
- the advantages of the use of such a later enable to be completely independant to the logging implementation

- need an implementation (only one) at runtime to provide the actual logging details

- in case of missing the logging "implementation" (or the logger binding),
  slf4j simply use a "NOP" implementation, which does nothing but shows reddish
  text

- slf4j-simple doesnt require any configuration, for simple use cases

- Log4j, JDK logger, Logback can be used with slf4j

- can experiment and swap different logger implementation, code can remain same

- http://saltnlight5.blogspot.com.tr/2013/08/how-to-configure-slf4j-with-different.html
