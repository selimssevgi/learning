# inventory

- describe a list of nodes

- sometimes is also called "hostfile"

- by default `/etc/ansible/hosts`

```shell
ai --list
ai --graph --vars

# run one time command on an inventory
ai -m command -a "git config --global --list" <name-of-the-group>
```

