# Dependency Management

- SBT uses Apache Ivy to implement and manage dependencies
- Apache Ivy is a dependecy manager with flexibility and configurability

- there are two ways to manage dependencies with SBT

## Automatic

- groupID % artifactID % version

```scala
libraryDependencies += "org.eclipse.jetty" % "jetty-server" % "7.3.0.v"

libraryDependencies += "org.scala-tools.testing" % "specs" % "1.6.2" % "test"
```

- SBT uses a set of resolvers to locate project dependencies and download them
- a resolver is mapped to a URL that hosts dependencies
- SBT uses Maven2 and Typesafe ivy releases to resolve dependencies

## Manual

- copy the .jar files to the lib folder
- SBT puts these .jar files on the cp when compiling, running, and testing
