# log4j2

```groovy
compile group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.12.1'
```

## simple usage

- provides a simple default configuration if none provided
  - just for error logging

```java
private static Logger logger = LogManager.getLogger(HelloLogging.class);
logger.error("This is an error message");
```

## configuration

- could be either programmatically or by file
- override default config by src/main/resources/log4j2.[xml, json, yaml, properties]

- log to standard output

```shell
log4j.rootLogger=DEBUG, STDOUT
log4j.logger.deng=INFO
log4j.appender.STDOUT=org.apache.log4j.ConsoleAppender
log4j.appender.STDOUT.layout=org.apache.log4j.PatternLayout
log4j.appender.STDOUT.layout.ConversionPattern=%5p [%t] (%F:%L) - %m%n
```

- log4j has three main components:

1. loggers : responsible for capturing logging information
2. appenders: responsible for publishing logging information to various preferred destionations
3. layouts: responsbile for formatting logging information in different styles

## Appenders

- provides Appender objects which are primarily responsible for printing logging
  messages to different destinations such as consoles, files, sockets,etc.

- Each Appender object has different properties associated with it, and these
  properties indicate the behavior of that object

## Layout

- possible options:
  - DateLayout
  - HTMLLayout
  - PatternLayout
  - SimpleLayout
  - XMLLayout

- %m : message
- %n : new line

