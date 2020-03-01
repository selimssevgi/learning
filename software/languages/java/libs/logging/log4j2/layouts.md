# Layouts

## PatternLayout

```xml
<PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %highlight{%level}{FATAL=bg_red, ERROR=red, WARN=yellow, INFO=green, DEBUG=blue} - %msg%n" /> 
```

- %d{HH:mm:ss.SSS}: the date of log event in specific format
- %t: thread name
- %level: log level of the message
- %highlight{%level}: is used to define colors for the pattern between curly brackets
- %msg%n: outputs the log message

- [all list of patterns](https://logging.apache.org/log4j/2.x/manual/layouts.html#PatternLayout)

## JsonLayout

- you need jackson-databind on the classpath for this

```xml
<JSONLayout complete="true" compact="false"/>
```
