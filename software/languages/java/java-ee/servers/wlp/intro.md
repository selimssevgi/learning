# wlp

- templates/servers: contains templates for new server creation

- lets say we have a javaee6 named template


```shell
$WLP_HOME/bin/server  create myServerName --template="javaee6"
```

- you can find the newly created server: $WLP_HOME/usr/servers/myServerName

```shell
# vim server.xml
<include location="/users/user/IdeaProjects/app-name/liberty.xml"/>
```

### liberty.xml

- it contains project specific data source definitions.

### intellij

- build settings, delegate to idea

- context root is "xxx-1.0.0-SNAPSHOT"
