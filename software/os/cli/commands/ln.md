# ln

```shell
ln -s existing-file link-file
```

- Links can either be “hard” or “symbolic”

## Hard Links

- We can use the ln command to create a link between two files.
- By default, the ln command will create a hard link between these files.

- Hard links create an identical copy of the linked file on disk, that gets updated automatically as the source file gets updated.
- That means if the content of the source is changed, so will the target file.

```shell
ln a.txt b.txt
```

* While the content of the source and target files are linked, if the source file gets deleted,
the target file will continue to live as an independent file, despite the severed link.

```shell
ln -f a.txt b.txt # even if b.txt exists
```

## Symbolic Links (-s)

- ln's default type of link a hard link.
- Unfortunately hard links do not work for directories.

- To create a link to a directory, we can use the -s flag to create a symbolic link.
- This can also be used for linking to files as well, not just directories.

- Symbolic links can also link to files or directories on other file systems.
- This makes symbolic links (symlinks) more powerful, and more common than the default hard links.

```shell
ln -s a.txt b.txt
```

- with the symbolic link the operating system creates a new, small file that points to the target file or directory.
