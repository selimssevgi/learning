# Maven Life Cycle

1. Generate a project
2. Execute Maven
3. Install a Maven artifact
4. Run the app

## Cycles / Phases

* validate : validate the project is correct
* compile  : compile the source code of a project
* test     : test the compiled source code using a unit testing framework
* package  : package the compiled code
* verify   : run any checks to verify the package is valid
* install  : install the package into the local repository
* deploy   : copies the final package to the remote repository

* integration-test  : deploy the package into an environment where integration tests can be run



- Plugin goals can be attached to each lifecycle phase

- Maven executes the goals attached to each phase

- Each phase has zero or more goals bound to it

- when you run 'mvn install', multiple goals are executed
