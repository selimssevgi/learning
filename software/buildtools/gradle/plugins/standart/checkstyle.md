# gradle checkstyle

- $PROJECTDIR/config/checstkyle.xml


```groovy
allprojects {
  apply plugin: 'checkstyle'

  checkstyle {
    //INFO: '> Unable to create a Checker: configLocation' update version
    toolVersion = '8.26'
    ignoreFailures = false
    maxWarnings = 0
  }
}
```

### suppressions.xml

- $PROJECTDIR/config/suppressions.xml

```xml
<module name="Checker">
  <module name="SuppressionFilter">
  <property name="file" value="${config_loc}/suppressions.xml"/>
  </module>
  <!-- other definitions -->
</module>
```
