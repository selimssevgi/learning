# @ComponentScan

- will scan the package that it is defined by default: "com.selimssevgi"

```java
package com.selimssevgi

@Configuration
@ComponentScan
public class Config {}
```

- we can instruct it to scan other packages

```java
package com.selimssevgi

@Configuration
@ComponentScan(basePackages = {"com.selimssevgi.subpackage"})
public class Config {}
```

- strings are not type safe or refactoring-friendly

```java
package com.selimssevgi

@Configuration
@ComponentScan(basePackageClasses = {MyConfig.class})
public class Config {}
```

- or we can define a marker interface

```java
package com.selimssevgi

@Configuration
@ComponentScan(basePackageClasses = {ComponentScannerMarker.class})
public class Config {}
```
