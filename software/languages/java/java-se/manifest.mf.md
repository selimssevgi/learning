# manifest.mf

- automatically created

- one manifest file for one archieve

- the pathname is always *META-INF/MANIFEST.MF*

```shell
# header: value
Manifest-Version: 1.0
Created-By: 1.7.0_06 (Oracle Corporation)
Main-Class: com.selimssevgi.app.Launcher # enable running with java -jar jarfile
```

```java
InputStream is = cl.getResourceAsStream("META-INF/MANIFEST.MF");
Manifest manifest = new Manifest(is);
manifest.getMainAttributes().getValue("Created-By");
```
