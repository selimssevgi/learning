# Starting

### Add ssh-key

- login without entering password

```shell
ssh-copy-id selimssevgi@todarch.com
```

### Add Docker User

- [DO Document](https://www.digitalocean.com/community/tutorials/how-to-use-the-digitalocean-docker-application)

```shell
adduser selimssevgi
su -l selimssevgi
docker version # give permission error
exit
usermod -a -G docker selimssevgi
su -l selimssevgi
docker version # works fine
```

### Add Swap

- [DO Document](https://www.digitalocean.com/community/tutorials/how-to-add-swap-space-on-ubuntu-18-04)

```shell
sudo swapon --show # no output mean, no swap
free -h
df -h # how much disk space you have
sudo fallocate -l 1G /swapfile
ls -lh /swapfile
sudo chmod 600 /swapfile
ls -lh /swapfile
sudo mkswap /swapfile
sudo swapon /swapfile
sudo swapon --show
free -h
```

## UFW

- [DO Document](https://www.digitalocean.com/community/tutorials/how-to-set-up-a-firewall-with-ufw-on-ubuntu-18-04)

### Domain Registrar

- [DO Document](https://www.digitalocean.com/community/tutorials/how-to-point-to-digitalocean-nameservers-from-common-domain-registrars)
