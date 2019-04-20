# Add Docker User

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

