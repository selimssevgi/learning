# tmux Commands

## Creating Sessions

```shell
# start tmux
$ tmux

# start a new session without a name
$tmux new-session

# creating named sessions
$ tmux new -s rails-project

# creates a session in the bg 
$ tmux new -s another-session -d

# create a named session and named window
$ tmux new -s thesession -n shell

# list of sessions
$ tmux list-sessions
$ tmux ls

# reattach to a session, -t is target, 0 is session name
$ tmux attach -t 0
$ tmux attach # if there is only one session

# to end/kill a session
$ tmux kill-session -t 0

# start tmux with a different conf file
$ tmux -f app.conf attach

# tmux version
$ tmux -V
```
