# custom tasks

- consist of two components:

1. custom task class that encapsulates the behavior of your logic: task type
2. actual task that provides the values for the properties exposed by the task class to configure the behavior


```groovy
class ReleaseVersionTask extends DefaultTask {
  @Input Boolean release
  @OutputFile File destFile
}
```

```groovy
task makeReleaseVersion(type: ReleaseVersionTask) {
  release = version.release
  destFile = versionFile
}
```

### out-of-box

- gradle ships with a wide range of custom tasks for commonly used functionality

- they are derived from DefaultTask

- Zip, Copy
