# MySQL Working with Backups

- Create back up

```shell
# save it a bash file: backup-dev
mysqldump -u dev dbname > dev.backup.sql
```

```shell
database=dnname
dropAndCreate="DROP DATABASE IF EXISTS ${database}; CREATE DATABASE ${database};"

echo "$database"
mysql -u -dev -e "$dropAndCreate"

echo "Restoring ${database}"
mysql -u dev "$database" < dev.backup.sql
```
