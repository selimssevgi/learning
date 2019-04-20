# docker-compose commands


```shell
alias dc='docker-compose'

# uses the docker-compose.yml in cwd
ds up

# just start the um service and services that um depends on
ds up um

# check running containers
ds ps

# detached while starting containers
ds up -d
```
