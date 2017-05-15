# ScalaCheck Overview

- tool for testing Scala programs by generating test data based on property specifications

- define a property that specifices the behavior of a piece of code

- a property is a testable unit

- ScalaCheck automatically generates random test data to check whether the
  property holds true


```scala
anyString.reverse.reverse == anyString
```

- the job of ScalaCheck would be to falsify this statement by generating random test data
