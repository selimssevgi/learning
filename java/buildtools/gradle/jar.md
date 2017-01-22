#  Create JAR file

## Name JAR artifact
jar block specifies how the JAR file will be named. In the following case, it
will render 'gs-gradle-0.1.0.jar'.

```groovy
jar {
  baseName = 'gs-gradle'
  version = '0.1.0'
}
```
