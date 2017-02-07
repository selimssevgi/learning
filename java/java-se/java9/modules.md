# Java Modules

- Moved from a monolithic to a set of (mostly) cohesive modules
- Each modules has a clear set of exports and dependencies
- You are using modules, even if you stay on the class path until you retire
- jlink allows creating runtime images a subset of the platform modules
- Modular development starts with a modular platform

```shell
$ java --list-modules
$ java --list-modules java.base
$ java --list-modules java.desktop
```

## What is module?

- One module reads another to access exported types.
- public doesnot mean completly accessible anymore.

```java
// src/stats.core/module-info.java
module starts.core {
  requires guava;
  exports com.acme.stats.core.clustering;
}

module stats.cli {
  requires starts.core;
  requires java.sql;
}
```

## Module Path

- is not equal to classpath.
- Problems with classpath solved.

```shell
$ javac --module-path dir1:dir2:dir3
$ javac -p
```

## jar

```java
$ jar --create --file mlib/xxx.jar --main-class com.acmestats.cli.Main
$ jar --file mlib/xxx.jar --print-module-descriptor
```

#### How to find what a lib or program needs?

```shell
// mapping each jar with its dependencies
$ jdeps -s lib/myapp.jar lib/mylib.jar

// generating module info
$ jdeps --gen-module-info src *.jar
```

- For libraries using reflection, it is not possible to know what they need. As
  a solution module can be declared as "weak module".
