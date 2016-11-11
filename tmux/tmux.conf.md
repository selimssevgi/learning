# Customizing Tmux

* Tmux looks for a system-wide configuration in /etc/tmux.conf
* Also looks in current user\'s home directory.

## Setting Options

* set  (short form of set-option) : sets option for tmux session
* setw (short  set-window-option) : sets option for tmux window

## Switches

* -g : global
* -r : repeatable, so you dont have press prefix each time

## Source the Conf file
In a tmux session

<prefix> : source-file ~/.tmux.conf
