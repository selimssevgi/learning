# Keybindings to be used in a tmux session
Default prefix is CTRL+B.


```shell

# toggle/zoom the current pane into full-screen
<prefix> z

# create a new window 
<prefix> c

# tmux use the process running as a default name
# to rename a window
<prefix> ,

# jump between windows
<prefix> <window_number>

# go to previous and next window
<prefix> p
<prefix> n

# when they are too many, find by name
<prefix> f

# visual list of windows
<prefix> w

# close a window
<prefix> &

# detach from current session, still keeps them running
<prefix> d

# split the current window into two panes vertically
<prefix> %

# split the current pane into 2 panes horizontally
<prefix>  <doublequotes>

# cycle through the panes
<prefix> o

# to move around panes
<prefix> <ARROW KEYS>

# cycle through default layouts
<prefix> <SPACEBAR>

# close a pane
<prefix> x

# all predefined tmux keybindings
<prefix> ?
```

## Tmux Command Mode

- go into command mode: <prefix> :

:new-window -n testing
