# Maven Goals

- Plugin goals can be attached to each lifecycle phase

- Maven executes the goals attached to each phase

- Each phase has zero or more goals bound to it

- Goals are actually just plugins configured in the maven install
- Super pom has these goals defined in it, which are added to effective pom

* clean: deletes the target directory and any generated resources
* compile: compiles all source code, generates any files, copies resources to our classes directory
* test: runs tests
* package: runs the compile first, runs any tests, packages the app based off of its packaging type
* install: runs the package and then installs it in your local repo
* deploy: runs the install and then deploys it to a corporate repo

