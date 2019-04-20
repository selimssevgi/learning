# if there are more than one version of postgresql, remove :

# also to solve the following error:
psql: could not connect to server: No such file or directory
  Is the server running locally and accepting
  connections on Unix domain socket "/var/run/postgresql/.s.PGSQL.5432"?

$ sudo apt-get remove --purge postgresql-9.x

# if necessary do a refresh installation
