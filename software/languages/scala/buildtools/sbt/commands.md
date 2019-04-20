# Sbt Commands

- sbt batch mode: slow starting jvm each time
- sbt shell mode: faster, ~testQuick for edit-compile-test cycle

```shell
$ sbt about   # first initialization and version control

$ sbt         # start sbt shell in project directory

> help

> console         # loads scala repl with project classes
> console-project # loads scala repl with build definition, debugging

> set name := "test project"
> show name | scalaVersion | version
> name | scalaVersion | version

> session list
> session save

> reload      # in case of change in build files, resolve new dependencies

> test        # run scala unit test
> ~testQuick  # run test during files changes, enter to stop

> clean       # cleans generated files in target/
> compile     # compiles the source code
> run         # run the main class, shows them if there are more than one
> run arg1    # run main class with arguments
> package     # creates jar

> exit        # or CTRL+D
```

## sbt Shell

- Has TAB completion and history

## History Commands

```shell
!          Show history command help.
!!         Execute the previous command again.
!:         Show all previous commands.
!:n        Show the last n commands.
!n         Execute the command with index n, as shown by the !: command.
!-n        ExecuteExecute the nth command before this one.
!string    Execute the most recent command starting with 'string.'
!?string   Execute the most recent command containing 'string.'
```
