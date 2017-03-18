# Sbt Commands

```shell
$ sbt about   # first initialization and version control

$ sbt         # start sbt shell in project directory

> console     # scala repl, loaded project, :quit

> ~testQuick  # run test during files changes, enter to stop

> reload      # in case of change in build files

> clean       # 
> compile     # compiles the source code
> test        # run scala unit test
> package     # creates jar
> run         # run the main methods, shows them if there are more than one

> exit        # or CTRL+D
```

## Run main method
```shell
$ sbt run arg1 arg2

# or

$ sbt
> run arg1 arg2
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
