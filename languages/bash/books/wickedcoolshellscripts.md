# Notes from Wicked Cool Shell Scripts Books

## Chapter 0 : A Shell Scripts Crash Course


```shell
$ echo "Hello World"
$ echo $PATH
```

* Add your scripts to path.

```shell
$ vim ~/.bash_profile
# export PATH="/repos/learning/bash/scripts/:$PATH"
```

*Subshell:* where one command is provided as an argument to another, bash uses a
subshell to run the second command and store the output for use by the first
command. (cat $(which neqn))

* Running shell scripts in the following two ways

1. by using sh command

```shell
$ vim intro
$ sh intro
```

2. by making them executable

```shell
$ vim intro # add shebang as first line: "#!/bin/bash"
$ chmod +x intro
$ ./intro
```

## Chapter 1: The Missing Code Library
