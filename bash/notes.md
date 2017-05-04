# Notes

## Enviroment

- There are two kinds:
  1. a login shell session
  2. a non-login shell session

- A login shell session is one in which we are prompted for our user name and password;
  when we start a virtual console session, for example.

- A non-login shell session typically occurs when we launch a terminal session in the GUI.

```shell
/etc/profile      # global conf script that applies to all users

~/.bash_profile   # personal startup file, extend or override global conf

~/.bash_login     # if ~/.bash_profile is not found, bash attempts to read this script

~/.profile        # if neither ~/.bash_profile nor ~/.bash_login is found,
                  # bash attempts to read this file
                  # this is the default in Debian-based distros, such as Ubuntu

/etc/bash.bashrc  # global conf script that applies to all users

~/.bashrc         # personal startup file
```

