# jib gradle config

```shell
plugins {
  id 'com.google.cloud.tools.jib' version '2.1.0'
}

jib {
  to {
    image = 'todarch/wisit-be'
  }
}
```


```shell
gradle jib
gradle jibDockerBuild # skip publishing
```
