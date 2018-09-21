# Maven Dependency

- allows for code reuse
- similar to using Java APIs
- find coordinates on central repository: https://mvnrepository.com/
- add coordinates into pom file

- maven supports internal and external dependencies


```xml
<dependencies>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```
