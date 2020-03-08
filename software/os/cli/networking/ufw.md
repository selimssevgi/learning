# ufw

- could be pre-installed

```shell
which ufw
```

```shell
sudo ufw status
sudo ufw status verbose
```

```shell
sudo ufw disable
sudo ufw enable
sudo ufw reload
```

## allow access from a trusted ip


```shell
## use static ip
sudo ufw allow from 192.168.0.1 to any port 22
```

## removing rules

```shell
sudo ufw status numbered
sudo ufw delete [number]
```
