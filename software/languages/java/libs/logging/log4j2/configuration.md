# log4j2 - configuration

### appenders

- an appender is basically responsible for sending log messages to certain output destionation

- most useful types of appenders in log4j2:
  - ConsoleAppender - logs messages to the System console
  - FileAppender - writes log messages to a file
  - RollingFileAppender - writes the messages to a rolling log file
  - JDBCAppender - uses a relational database for logs
  - AsyncAppender - contains a list of other appenders and determines the logs for these to be written in a separate thread

### layouts

- are used by appenders to define how a log message will be formatted

- a list of common ones:
  - PatternLayout - configures messages according to a String pattern
  - JsonLayout - defines a JSON format for log messages
  - CsvLayout - 

### loggers

- besides the Root logger, we can also define additional Logger elements with
  different log leves, appenders or filters

- each Logger requires a name that can be used later to reference it

### lookups

- represent a way to insert external values into the log4j2 configuration

```xml
filePattern="logs/$${date:yyyy-MM}"
```

- ${date:yyyy-MM} inserts current date into file name
- $ is an escape character

- can also insert system properties: ${sys:property\_name}

```xml
fileName="${sys:path}/app.log"
```

- can also insert java environment info: ${java:property\_name}

```xml
${java:version} - ${java:os}
```
