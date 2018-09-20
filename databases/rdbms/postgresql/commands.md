# psql Commands

```shell
$ sudo service postgresql status
$ sudo service postgresql start
$ sudo service postgresql stop

# create a new user
$ sudo -u postgres createuser springtest

# add password to user
$ sudo -u postgres psql postgres
postgres=# ALTER USER springtest WITH password 'test';

# create a new database
$ sudo -u postgres createdb tododb --owner springtest

```


```shell
# list all databases
sudo -u postgres psql -l
```
