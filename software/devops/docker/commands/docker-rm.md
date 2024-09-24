# docker rm

- All containers use hard drive space to store logs, container metadata, and
  files that have been written to the container file system

- All containers also consume resources in the global namespace like container
  names and host port mappings

```shell
# force removal and remove volumes associated with it
docker rm -vf cass2 cass-shared
docker rm --help

docker rm -v $(docker ps -aq) # remove all stopped containers
```

```shell
docker ps -a # show all event exited ones
docker rm wp

docker rmi image1 image2 image3
```

- Cannot remove a running/restarting containers

```shell
docker stop wp  # SIG_HUP , finalization and clean up
docker rm -f wp # SIG_KILL, immeadiate kill
docker kill wp  # SIG_KILL, you only if should stop before 30-second max stop time
```

