# lsof

- list open files


```shell
lsof | head

# which processes have /some/file open?
lsof /var/log/nginx

# find all files that a process has opened?
ps aux | grep nginx # find some pid
lsof -p 1199

# where is the binary for process X?
lsof -p 1199 | grep bin

# which share object a processes uses?
lsof -p 1199 | grep so

# where this process/program logs?
lsof -p 1199 | grep log

# which files a user open?
lsof -u ssselim

# which process listens on port 80?
lsof -i :80

lsof -i tcp
```
