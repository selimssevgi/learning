# Union File System(UFS)

- Authors need to know the impact that adding, changing, and deleting files have on resulting images

- Authors need to have a solid understanding of the relationships between layers
  and how layers relate to images, repositories, and tags

```shell
docker run --name mod_ubuntu ubuntu:latest touch /mychange
```

- The file system is implemented with a union file system

- UFS is made up of layers

- Each time a change is made to a UFS, that change is recorded on a new layer on
  top of all of the the others

- Like additions, both file changes and deletions work by modifying the top layer

- Most union file systems use something called copy-o-write (copy-on-change)

- When a file in a read-only layer (not the top layer) is modified, the whole
  file is first copied from the read-only layer into the writable layer before
  the change is made
