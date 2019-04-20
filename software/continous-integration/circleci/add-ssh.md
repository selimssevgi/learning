# Add SSH

- Go to project, click on the gear on the right side of the project

- Permissions -> SSH Permission

- you (may) need to use one wihtout passphrase

- Copy the content of the private key and add it to CircleCI

```shell
cd ~/.ssh
vim no-pass
```

- Then use the fingerprint in config.yml

```yml
- add_ssh_keys:
    fingerprints:
      - "80:2d:9c:70:d7:07:3f:fc:25:8d:b1:ed:4b:cd:96:73"
```
