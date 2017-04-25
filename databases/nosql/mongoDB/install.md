# Install

- https://docs.mongodb.com/master/tutorial/install-mongodb-on-ubuntu/


```shell
# see if running
ps aux | grep mongod

# start
sudo service mongod start

# be sure it is listening
cat /var/log/mongodb/mongod.log

# stop
sudo service mongob stop
```
