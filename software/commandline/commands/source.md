# source

- The Bash source built-in is a synonym for the Bourne shell . (dot) command.

- The script does not need execute permission in this case.

- Commands are executed in the current shell context, so any changes made to
  your environment will be visible when the script finishes execution.

```shell
source a-script-file

. a-script-file
```
