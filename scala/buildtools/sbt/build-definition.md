# Build Definition

- defined in build.sbt

- consists of a set of projects (of type Project)

- top level 'objects' and 'classes' are not allowed
- they should go in project/ directory as Scala source files

- can contain vals and defs in addition to settings
- all others are evaluated before settings regardless of definition order
- use lazy vals to avoid initialization problems

```shell
# define a subproject located in the currect directory
lazy val root = (project in file("."))
  .settings(
    name         := "hello",                # setting expression
    organization := "com.selimssevgi",
    scalaVersion := "2.12.1",
    version      := "0.0.1-SNAPSHOT",
  )
```


- setting expression: key := body

- A key is an instance of SettingKey[T], TaskKey[T], InputKey[T]
- T is the expected type

## Keys

- there are three flawors of key

1. SettingKey[T] : computed once
2. TaskKey[T]    : called a task, recomputeted each time
3. InputKey[T]   : a key for a task that has CL arguments as input

- All predefined keys are defined in the sbt.Keys object
- sbt.Keys is automatically imported in the build.sbt


