# An example from 'tdd by example'

- there many null checks after requesting an object

```java
// java.io.File
public boolean setReadOnly() {
   SecurityManager guard = System.getSecurityManager();
   if (guard != null) {
      guard.canWrite(path);
   }
   return fileSystem.setReadOnly(this);
}
```

- Will programmers be careful enough so will not forget to check it once?


```java
// LaxSecurity
public void canWrite(String path) {
}

// somewhere else
public static SecurityManager getSecurityManager() {
      return security == null ? new LaxSecurity() : security;
}
```

- Now there will not be need for null check

```java
public boolean setReadOnly() {
   SecurityManager security = System.getSecurityManager();
   security.canWrite(path);
   return fileSystem.setReadOnly(this);
}
```
