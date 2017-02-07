# Java 7 (2011)

- First from Oracle
- Brought a lot of syntactic sugar
- invokeDynamic
- java.lang.invoke
- forkJoin
- Better file IO

* Project Coin
  - Switch for String
  - Diamon operator without type
  - Binary integer literals(0b0101010)
  - Underscores(1_000_000)
  - Try with resources
  - Multiple catches


### Paths

```java
// using Paths.get(...) to create a path
Path dictionary = Paths.get("/", "usr", "share", "dict", "web2");
Path home = Paths.get("/home/ssselim");

// using resolve to find nested paths
Path docs = home.resolve("Documents");

// can resolve siblings as well
Path downloads = docs.resolveSiblings("Downloads");

// project directory
Path project - Paths.get(".");
System.out.println(project.toAbsolutePath());
```

