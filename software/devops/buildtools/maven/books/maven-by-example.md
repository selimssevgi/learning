# Notes from Maven by Example

- http://books.sonatype.com/mvnex-book/reference/installation-sect-universal-reuse.html

# Chapter 1

- universal reuse through maven plugins
- maintained centrally and shared universally (maven central repository)

- ${basedir}/src/main/java
- ${basedir}/src/main/resources
- ${basedir}/src/main/webapp
- ${basedir}/src/test/java

## Chapter 3

- Maven always executes against an effective POM, a combination of:
  - settings from project's pom.xml
  - all parent POMs
  - a super-POM defined within Maven
  - user-defined settings
  - active profiles

- All projects ultimately extend the super-POM
- Super-POM defines a set of sensible default configuration settings

```shell
# useful for debugging a large build settings
mvn help:effective-pom

mvn archetype:generate
```

- archetype is the identifier of a plugin
- generate is the identifier of a goal

- A Maven Plugin is a collection of one or more goals
- A goal is a specific task that may be executed as a standalone goal or along
  with other goals as part of a larger build

- Plugin goals can be attached to a lifecycle phase
- As Maven moves through the phases in a lifecycle, it will execute the goals
  attached to each particular phase.

```shell
mvn install #install is a phase of a lifecycle
mvn compiler:compile
```

- Maven executes all phases up to the install phase, and in the process of
  stepping through the lifecycle phases it executes all goals bound to each phase

-  Maven repositories are both a local cache of artifacts of downloaded from a
   remote repository and a mechanism for allowing your projects to depend on
   each other

- The fact that Maven downloads POM files in addition to artifacts is central to
  Maven's support for transitive dependencies.

- A dependency in Maven isn't just a JAR file, it's a POM file that, in turn,
  may declare dependencies on other artifacts. These dependencies of
  dependencies are called transitive dependencies

- 'provided' scope tells Maven that a dependency is needed for compilation, but
  shoul not be bundled with the output of a build

- Wehn Maven is executed against a project with submodules, Maven first loads
  the parent POM and locates all of the submodule POMs. Maven then puts all of
  these project POMs into something called the 'Maven Reactor'.

- Maven Reactor analyzes the dependencies between modules, and takes care of
  ordering components to ensure that interdependent modules are compiled and
  installed in the proper order.

- One the Reactor figures out the order in which project must be built, Maven
  then executes the specified goals for every module in the multi-module build.
