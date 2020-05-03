# cron jobs



```shell
# list current user's cron table
crontab -l

# list root's cron table
sudo crontab -l

# edit user's crontab
crontab -e
```

```shell
# ┌───────────── minute (0 - 59)
# │ ┌───────────── hour (0 - 23)
# │ │ ┌───────────── day of month (1 - 31)
# │ │ │ ┌───────────── month (1 - 12)
# │ │ │ │ ┌───────────── day of week (0 - 6) (Sunday to Saturday;
# │ │ │ │ │                                       7 is also Sunday on some systems)
# │ │ │ │ │
# │ │ │ │ │
# * * * * *  command_to_execute

* * * * *  # run every minute

0 0 * * *  # every midnight

0 0 1,15 * *  # on 1st and 15th of every month

*/10 * * * *  # every 10 mins

0 0 */3 * *  # every 3 days
```
