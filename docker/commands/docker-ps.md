# docker ps

- listing, stopping, restarting and viewing output of containers

- Shows only "running" containers by default

```shell
docker ps

docker ps -a # to see all containers in any state

docker ps --latest --quiet
```

- The container ID
- The image used
- The command executed in the container
- The time since the container was created
- The duration that the container has been running
- The network ports exposed by the container
- The name of the container


```shell
docker restart <name-of-container>
docker logs <name-of-container> # --follow | -f
docker stop <name-of-container> # tells the program with PID #1 in the container to halt
```
