# Dev Workflow

- back development database
- backup-dev(backup-dev-before.sh)
- work on the database design - add or change columns directly
- saved the equvalent sql to somewhere representing the changes
- check out the database work well with project as intendent
- before using the migration tool(flyway) backup the "changed dev" database
- backup-dev(backup-dev-after.sh)
- restore-dev-before.sh
- create succint sql from the above steps(fixing alter table/column parts)
- create a migration file from that sql(V005--add-phonenumber-col.sql)
- Remove any database name from scripts(you may run it againts a different databasename)
- flyway info -> flyway migrate


```shell
# save it a bash file: backup-dev-before
mysqldump -u dev dbname > dev.before.backup.sql

# save it a bash file: backup-dev-after
mysqldump -u dev dbname > dev.after.backup.sql
```

```shell
# restore-dev-before
database=dnname
dropAndCreate="DROP DATABASE IF EXISTS ${database}; CREATE DATABASE ${database};"
backupFile=dev.before.backup.sql

echo "$database"
mysql -u -dev -e "$dropAndCreate"

echo "Restoring ${database}"
mysql -u dev "$database" < "$backupFile"

# can do the same changing the back up file for restore after
# restore-dev-after
# backupFile=dev.after.backup.sql
```

## In case of Failing

- while running a migration script, database(mysql) may not support
  transactional scheme changes. If there is an error in middle of our script,
  database will end up in way that we did not indent to.


- "flyway repaire" cleans up failed migration, can be used instead of manual cleaning
