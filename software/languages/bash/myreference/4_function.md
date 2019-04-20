# Bash Functions

- they must appear before you attempt to use them.
- The function body must contain at least one valid command.
- The simple way to fix this is to place a "return" statement in each function body.

## Syntax
```shell
function_name()
{

}

function greet {
  echo "Hi $1 there!"
}
```

```shell
system_info()
{
  # temporary function stub
  echo "function system_info"
}
```

## How to call a function
```shell
function_name
system_info
```

### An error exit function

```shell
error_exit()
{
  echo "$1" 1>&2
  exit 1
}

if cd $some_directory; then
    rm *
else
  error_exit "Cannot change directory!  Aborting."
fi
```

