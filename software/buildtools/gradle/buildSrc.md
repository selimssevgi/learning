# buildSrc directory

- an alternative location to put build code
- a real anabler for good software development practices

- buildSrc/src/main/groovy
- buildSrc/src/main/java

- any code that's found in these directories is automatically compiled and put
  into the classpath of your regular gradle build script

- the difference between defining a class in the build script vs a separate
  source file is that you will need to import classes from the gradle api
