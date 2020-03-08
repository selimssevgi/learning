# enhanced task

```groovy
task makeReleaseVersion(type: ReleaseVersionTask) {
  release = version.release
  destFile = versionFile
}
```
