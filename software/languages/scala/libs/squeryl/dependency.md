# Use Squeryl

```scala
val squeryl = "org.squeryl" %% "squeryl" % "0.9.5-6"

// one of databases
val h2            = "com.h2database" % "h2" % "1.2.127"
val mysqlDriver   = "mysql" % "mysql-connector-java" % "5.1.10"
val posgresDriver = "postgresql" % "postgresql" % "8.4-701.jdbc4"

libraryDependencies ++= Seq(
  squeryl, h2
)
```
