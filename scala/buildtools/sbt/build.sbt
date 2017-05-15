// each line is an expression
// each line needs to be separated by a blank line
// otherwise, SBT can't distinguish them

// expression in the build file create a list of settings for SBT

// A build definition is nothing but a list of settings represented by Setting[T]

// when all the settings are evaluated, SBT creates an immutable Map of key value pairs
//
// name.:= "Testing SBT", := is a method call on a key
name :=("Testing SBT")

version := "1.0"

scalaVersion := "2.12.1"

// import statements should go at the top of the file
//
scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-server" % "7.0.0.RC2",
  "org.scala-tools.testing" % "specs" % "1.6.2" % "test" )

// sbt built files are type-safe
// the type of key determines the type of the value

organizationHomepage := "22" // type mismatch: f:String, r:Option[java.net.URL]
