# zsh


```shell
zsh --version
cat /etc/shells
which zsh

echo $0                   # current shell in use
exec /usr/bin/zsh         # changing temporarily
chsh -s /usr/bin/zsh      # chaging permantly after re-login
sudo chsh -s /usr/bin/zsh # root


# PAM error
cat /etc/passwd | grep root
# see if it has a valid shell path, if not change it
sudo vim /etc/passwd
```
