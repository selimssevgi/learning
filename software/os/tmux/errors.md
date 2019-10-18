# Errors and Solution

* After updating tmux following error may occure:
```shell
$ tmux
protocol version mismatch (client 8, server 6)
```

Exit from all session

```shell
$ pgrep tmux
3429
$ /proc/3429/exe attach
```

* If still doesnt work, logout and login.

* Tmux read bash_profile, doesnt read bashrc. If because of normal terminal you
  source them in other order, bashrc is not sourced and some stuff doesnt work
  as expected.
