# tomcat configuration

## change port

```shell
vim $TOMCAT_HOME/conf/server.xml
# change port 8080 to whatever you want
```

```xml
<Connector port="8080" ... />
```

## add tomcat user

- access "Server Status", "Manager App", "Host Manager"

```shell
vim $TOMCAT_HOME/conf/tomcat-users.xml
```

```xml
  <role rolename="admin-gui"/>
  <role rolename="manager-gui"/>
  <user username="admin" password="admin" roles="admin-gui, manager-gui"/>

</tomcat-users>
```

- restart tomcat
