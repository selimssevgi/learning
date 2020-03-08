# vetoed

- veto a bean

- veto a whole package

```java
@Vetoed // do not pick this as a cdi bean
public IsbnGenerator implement NumberGenerator {}
```

```java
@Vetoed
package com.selimssevgi.injection;
```
