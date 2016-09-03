#!/bin/bash

The difference between a good program and a poor one is often measured in terms of the program's robustness.
That is, the program's ability to handle situations in which something goes wrong.

# Example of a really bad idea

cd $some_directory
rm *


#check the exit status

cd $some_directory
if [ "$?" = "0" ]; then
    rm *
else
  echo "Cannot change directory!" 1>&2
  exit 1
fi

# A better way

if cd $some_directory; then
    rm *
else
  echo "Could not change directory! Aborting." 1>&2
  exit 1
fi

## USE ERROR EXIT FUNCTION. PROMOTES LAZINESS!

This value, which is an integer in the range of 0 to 255, indicates the success or failure of the command’s execution.
By convention, a value of zero indicates success and any other value indicates failure.
The shell provides a parameter that we can use to examine the exit status.

[me@linuxbox ~]$ ls -d /usr/bin
/usr/bin
[me@linuxbox ~]$ echo $?
0
[me@linuxbox ~]$ ls -d /bin/usr
ls: cannot access /bin/usr: No such file or directory
[me@linuxbox ~]$ echo $?
2

The shell provides two extremely simple builtin commands that do nothing except terminate with either a zero or one exit status.
The true command always executes successfully and the false command always executes unsuccessfully:

[me@linuxbox~]$ true
[me@linuxbox~]$ echo $?
0
[me@linuxbox~]$ false
[me@linuxbox~]$ echo $?
1


EXIT

In order to be good script writers, we must set the exit status when our scripts finish. To do this, use the exit command.
The exit command causes the script to terminate immediately and set the exit status to whatever value is given as an argument.
For example:

exit 0

exits your script and sets the exit status to 0 (success), whereas

exit 1

exits your script and sets the exit status to 1 (failure).
