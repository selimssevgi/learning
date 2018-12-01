# SBT

- It is an interactive build tool

- There are three ways to configure projects with SBT:
  - use the .sbt file to configure the build definition of the project
  - use the .scala file for the build definition
  - Use both .sbt and .scala files to configure the project

- SBT works purely by convention
- It looks for Scala source files in the base directory, inside:
  - src/main/scala
  - src/main/java


```shell
mkdir test
cd test
vim hw.scala
sbt
> run # run task looks for classes in the cp that define the main method

> tasks # see all available SBT tasks
```

- By default, SBT will use the Scala version that shipped with SBT to compile
  the source code of the project

```scala
> scala-version

> set name := "Testing SBT"
> set version := "1.0"
```
