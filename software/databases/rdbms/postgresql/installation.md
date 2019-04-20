https://www.postgresql.org/download/linux/ubuntu/
https://launchschool.com/blog/how-to-install-postgres-for-linux

- add main repo from above website for the latest version.

- After installation there will be just a role/user to interact with postgresql.
  it is 'postgres'. 

By default Postgres creates a postgres user and is the only user who can connect to the server.
We’ll want to create ourselves on the server with superuser capabilities with the same name as our login name:
$ sudo -u postgres createuser --superuser $USER

Next, we’ll have to create a database with the same name as our login name 
since this is what Postgres expects by default when connecting to the server with your login name:
$ sudo -u postgres createdb $USER

Navigate to your home directory and enter the following command 
to create the .psql_history in order to save your history:
$ touch .psql_history

$ psql   # login postgresql server with current username

# \q # exiting

