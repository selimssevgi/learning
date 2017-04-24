# Scala REPL


```shell
$ scala
> :help
> :paste                     # paste chunk of code
> :reset                     # reset
> :q or :quite               # exit scala interpreter
```
- start scala repl with color hightligts
  $scala -Dscala.color # add alias as scala

- REPL is eager to parse anything it gets: this creates the problem of defining
  a class and its companion object afterwards. Either use a holder object or
  :paste mode to define them together.

- if line is too long, you can put it on multiline, just enter and continue.
  following line will be shown with a vertical bar on the next lines.
  Enter twice two escape multiline mode if smth goes wrong.
