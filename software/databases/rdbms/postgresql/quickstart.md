$ sudo -u postgres psql

postgres=# create user "myappusr" with password '_password_';
postgres=# create database "myapp_development" owner "myappusr";

$ sudo vim /etc/postgresql/9.6/main/pg_hba.conf

after postgres entry:
local   all             hiddenslate                               trust

$ sudo service postgresql restart

$ psql -d myapp_development -U myappusr


===========================================

# Login and Connect as Default User
$ sudo -u postgres psql # should end up in postgres prompt

# Changing the Password
postgres=# ALTER USER postgres PASSWORD 'myPassword';

# Exit
postgres=# \q

# start/restart postgres server
$ service postgresql restart

# Create a DB
$ createdb mydb
