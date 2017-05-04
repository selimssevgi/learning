# Bash Variables

- by convention shell variables typically use uppercase names.
- Since commands in linux are almost always lowercase. It will make them stand out.

## Defining a variable

- all uppercase letter
- no spaces allowed around assign operator

```shell
FILE=/tmp/abc.out

VARIABLENAME="variableValue" #no spaces are allowed
```

- The shell essentially sees the command line as a pile of commands
- Command arguments seperated by spaces
- foo=baris considered as a command
- The problem with foo = bar is the shell sees the word foo seperated by spaces
  and interprets it as a command
- Likewise, the problem with the command X=hello world is that the shell
  interprets X=hello as a command, and the word "world" does not make any sense.
  (since the assignment command doesn't take arguments).

```bash
X=hello world # error

X="hello world" # OK
```

## Using value of variable

- use $ sign

```bash
echo $VARIABLENAME
```

## Adding Attributes to Variables

```bash
declare -i d=123     # d is an integer
declare -r e=456     # e is read-only
declare -l f="SeLiM" # will be all lower case. f is selim
declare -u g="SeLiM" # will be all upper case. g is SELIM
```
