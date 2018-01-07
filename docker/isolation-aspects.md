# Isolation Aspects

The containers that Docker builds are isolated with respect to eight aspects.

1. PID namespace  -  Process identifiers and capabilities
2. UTS namespace  -  Host and domain name
3. MNT namespace  -  File systen access and structure
4. IPC namespace  -  Process communication over shared memory
5. NET namespace  -  Network acess and structure
6. USR namespace  -  User names and identifiers
7. chroot()       -  Controls the location of the file system root
8. cgroups        -  Resources protection

