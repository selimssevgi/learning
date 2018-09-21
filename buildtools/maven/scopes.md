# Scopes

- There are 6 scopes available for dependencies:

1. compile: default scope, artifacts available everywhere

2. provided: like compile, means that the artifact is going to be provided where it is deployed
  - servlet-api.jar, xml-apis,
  - Available in all phases, but not included in final artifact

3. runtime: not needed for compilation, but needed for execution
  - jdbc driver. Class.forName
  - not available for compilation, but included in all other phases
  - not included in final artifact

4. test: only available for the test compilation and execution phase

5. system: similar to provided, you specify a path to the jar on your file system
  - very brittle and defeats the purpose of maven, don't use!

6. import: advanced topic, deals with dependencyManagement sections
