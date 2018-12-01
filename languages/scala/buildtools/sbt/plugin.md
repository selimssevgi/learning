# SBT plugins

- An SBT plug-in extends the build definition by adding new tasks and settings

## Local Plugins

- project/plugins.sbt is typically used to configure SBT plugins for project


## Global Plugins

- Global plug-ins are automatically added to all SBT projects

```shell
touch ~/.sbt/plugins.sbt
touch ~/.sbt/build.sbt
```

```scala
// plugins.sbt

addSbtPlugin("me.lessis" % "np" % "0.2.0")
```


```scala
// build.sbt
seq(npSettings: _*)
```


```shell
mkdir test
cd test
sbt np
```
