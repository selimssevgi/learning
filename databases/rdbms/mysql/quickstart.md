#

- Start/Stop MySQL Server

```shell
$ ps aux | grep mysql
$ sudo service mysql start
$ sudo service mysql stop
```

#### Connecting to MySQL server
The 'mysql' is a MySQL command line tool. It is a simple shell.

```shell
$ mysql -u root -p
```

#### mysql Commands

```java
# ctrl+d -> exit
# ctrl+l -> clear

mysql> help
mysql> exit
mysql> system pwd
```

*NOTE:* We need to distinguish between mysql commands and SQL statements. SQL
statements are terminated with a semicolon.

#### Some SQL commands

```shell
mysql> SHOW DATABASES;
mysql> CREATE DATABASE mydb;
mysql> USE mydb; # in order to work with a db, we must first select it
mysql> SHOW TABLES;
mysql> source cars.sql; # full path of sql file
mysql> SELECT * FROM Cars; # table name is case-sensitive
mysql> DESC Cars; # show fields and types
```

```shell
# check if mysqld is alive
$ mysqladmin -u root -p ping
$ mysqladmin -u root -p shutdown
```
