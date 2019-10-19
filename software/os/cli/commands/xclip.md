# xclip

- interface to X11 clipboard

- put output of a command or a file directly into system clipboard

- useful specially copy/pasting long text in terminal

- install it if is not there already

```shell
ls -l | xclip

# C^V may not work, mouse wheel could work

man xclip # see -selection option

ls -l | xclip -selection clipboard # C^V works
```
