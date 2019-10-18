# Text and Buffers in Tmux

In copy mode, by default arrow keys let the cursor move around the screen.
Use the vim keys for moving in tmux.conf.

```shell
# go into Copy mode
<prefix> [

# add the following in tmux.conf, and treat the buffer as text in vim
# setw -g mode-keys vi

# copying text in copy mode
<SPACE> start selecting the text
<ENTER> selected text gets copied

# pasting copied text
<prefix> ] # pastes buffer 0

# show the content of the paste buffer
$ tmux show-buffer
:show-buffer

# list all paste buffers
<prefix> =

:list-buffers
:choose-buffer

# exit copy mode
<enter>
```
