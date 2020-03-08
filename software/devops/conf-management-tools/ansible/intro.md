# ansible intro

### reconciliation

* current state (absent, differs, same)

* desired state (add, replace, nothing)

- find and remove the difference between current and desired state

- what: current statue/desired state
- how: operations to get the desired state

* ansible will get us to desired state without specifying how

- ansible is a declarative


### architecture

- control node - has ansible running
- managed node - no ansible, ansible uses ssh to connect and execute


- see the list of supported connection/controlling type

```shell
ansible-doc -t connection -l
```

### ad-hoc commands

- can be used to just run one-time commands or test stuff


```shell
ansible --module-name copy \
  --args "src=master.gitconfig dest=~/.gitconfig" \
  localhost
```

-- `--check` for dry-run, just tells you if changes would be made

```shell
ansible --module-name copy \
  --args "src=master.gitconfig dest=~/.gitconfig" \
  --check
  localhost
```

- `--diff` use it to also see changes

```shell
ansible --module-name copy \
  --args "src=master.gitconfig dest=~/.gitconfig" \
  --check \
  --diff \
  localhost
```

- remove `--check` to execute it, keep `--diff` to also see changes

```shell
ansible --module-name copy \
  --args "src=master.gitconfig dest=~/.gitconfig" \
  --diff \
  localhost
```
