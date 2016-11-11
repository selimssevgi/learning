# Tmuxinator
Is a simple tool to write and manage different tmux confs. 
Window layouts and commands can be defined in simple YAML format.

- default location for tmuxinator project is ~/.tmuxinator/
```shell
# create a new tmuxinator project
# creates it with default settings if doesnt exist
$ tmuxinator open development

# loads the tmux session for given project
$ tmuxinator <project>

# list all current projects
$ tmuxinator list

# copy a project conf
$ tmuxinator copy <source> <destination>

# delete a project
$ tmuxinator delete <project>

# check status
$ tmuxinator doctor
```
