# apache ant

- Another Neat Tool

- its main purpose is to provide automation for typical tasks needed in java projects

- ant's core is written in java
- build file is expressed through xml

- does not provide a dependency manager
- however, integrates well with Apache Ivy(full-fledged, standalone dependency manager)

- ant ship with a wide range of predefined tasks
- you can extend your build script's capabilites by writing your own tasks in java

### shortcomings

- because of xml verbose build scripts

- complex build logic leads to unmaintainable scripts

- no guidelines, every project could have different setup

- doesnot expose an api

- without ivy, is not easy to manage dependencies

### terminology

- a *task* is a piece of executable code

- a *target* is a set of tasks you want to be executed

- mandatory to all ant projects is the overaching containerm the *project*. it
  is the top level element in an ant script and contains one or more targets
