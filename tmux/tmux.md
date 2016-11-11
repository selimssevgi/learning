
Tmux: A terminal multiplexer

If a traditional terminal is closed, all the running programs in that terminal are gone.
However, tmux keeps them running even after detaching the session.
After reataching a session, tmux brings up all the same when detached.

Server: Tmux runs in the bg of your system as a process. A server contains sessions.

Session: is a collection of related windows(think tabs),

Window: A tmux window functions much like a terminal tab

Pane: each window can be split into horizontal or vertical sections called panes.
Behaves as if it were its own terminal.

