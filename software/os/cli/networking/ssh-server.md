# ssh server

- it may not be installed or started by default

```shell
ssh localhost
# connection refused means ssh server is not running
```

- check if is installed

```shell
sudo systemctl status ssh
# unit not found means not installed
```

- install

```shell
sudo apt-get install openssh-server
```

- after installation is already up and running

```shell
sudo systemctl status ssh
ssh localhost
```

## ssh service

```shell
sudo systemctl status ssh
sudo systemctl start ssh
sudo systemctl stop ssh
sudo systemctl restart ssh
```
