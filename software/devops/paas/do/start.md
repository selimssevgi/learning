# Starting

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
