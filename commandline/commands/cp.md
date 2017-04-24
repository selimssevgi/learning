# cp: copy

- cp will allows you to list several files you would like to copy.
- When you do this, however, the last argument must be a directory,
- the original file names of the source files will be used as the names of
  the new files in the target directory.

```shell
$ cp a.txt b.txt foo

$ cp *.txt foo

$ cp -Rv dir1 dir2

$ cp -f a.txt b.txt # force copying
```

