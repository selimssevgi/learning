# Bash if Statements
It makes a decision based on the exit status of a command.

### Syntax

```shell
if commands; then
  // commands
elif commands; then
  // commands
else
  // commands
fi
```

### Examples

```shell
if [ $# -ne 1 ];
  echo "Usage: $0 command" >&2
  exit 1
fi

if true; then
  echo "It's true."
fi

if [ -f .bash_profile ]; then
  echo "You have a .bash_profile. Things are fine."
else
  echo "Yikes! You have no .bash_profile!"
fi

if [ "$character" = "1" ]; then
  echo "You entered one."
elif [ "$character" = "2" ]; then
  echo "You entered two."
else
  echo "You did not enter a number between 1 and 2."
fi

# test for the root. Superuser has id of 0
if [ $(id -u) != "0" ]; then
  echo "You must be the superuser to run this script" >&2
  exit 1
fi
```

```shell
if [ expression ]

if [[ expression ]] # extended test

if (( expression )) # integer comp

if expression

if [[ $a =~ [0-9]+ ]] # =~ tells regex will be used!

if [ -e $file ] # file existence

if [ $first -eq 0 ] && [ $second -eq 0 ]

if [ ! -z $ip ] # if not empty
```






Notice the ">&2" at the end of the echo command. This is another form of I/O direction.
You will often notice this in routines that display error messages.
If this redirection were not done, the error message would go to standard output.
With this redirection, the message is sent to standard error.
Since we are executing our script and redirecting its standard output to a file,
we want the error messages separated from the normal output.
