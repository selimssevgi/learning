# dependency insight

- sometimes you want to know what a version is picked

- explains how and why a depedency is in the graph

- two parameters needed:
  - name of the configuraiton (by default is compile)
  - the dependency itself

```shell
gradle -q dI --configuration cargo --dependency xml-apis:xml-apis
```
