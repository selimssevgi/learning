# Filtering in Vim

The !motion_command takes a block of text and filters it through another program.

Takes specified text as input and run the system command and replaces that with the output.

## Scenario
Lets say you are on the line number 1. Doing the following:

!10G

Now in a way you select the text block in 1 through 10.

!10Gsort

Now you are using sort command on the selected text as input,
and output of the command replaces the text, filtering it!

- !!     -> runs the current line throught a filter.
- !!ls   -> include the current directory file list.
- !!date -> include current date in the file

Fri Oct 28 22:48:18 EEST 2016
