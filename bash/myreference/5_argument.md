# Arguments in Bash
To handle options on the command line, we use a facility in the shell called positional parameters.
Positional parameters are a series of special variables ($0 through $9) that contain the contents of the command line.

#### Example

```shell
[me@linuxbox me]$ some_program word1 word2 word3
```

If some_program were a bash shell script, we could read each item on the command line
because the positional parameters contain the following:

- $0 would contain "some_program"
- $1 would contain "word1"
- $2 would contain "word2"
- $3 would contain "word3"

you will want to check to see if you have arguments on which to act.
There are a couple of ways to do this.
First, you could simply check to see if $1 contains anything like so:

```bash
if [ "$1" != "" ]; then
  echo "Positional parameter 1 contains something"
else
  echo "Positional parameter 1 is empty"
fi
```

Second, the shell maintains a variable called $#
that contains the number of items on the command line
in addition to the name of the command ($0).

```java
if [ $# -gt 0 ]; then
  echo "your command line contains $# arguments"
else
  echo "your command line contains no arguments"
fi
```