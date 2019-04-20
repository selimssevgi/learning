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

- connect to a database with username and password

```shell
# asks password
psql --host=localhost --dbname=todarchtd --username=dbuser
psql \
  --host=localhost \
  --port=5445 \
  --dbname=todarchtd \
  --username=dbuser
```


```shell
# list databases
postgres=# \l

# list all tables in current db
postgres=# \dt *.

```

### Without Password Prompt

- Can have PGPASSWORD environment variable
- Or provide it while running the command
- it is deprecated, but useful

```shell
PGPASSWORD=postgres psql ...
```
