# dependency cache structure


```groovy
task printDeps << {
  configurations.getByNAme('cargo').each { dep ->
    println dep
   
}
```

- $HOME/.gradle/caches/modules-2/
- $HOME/.gradle/caches/<identifier-specific-to-gradle-version>/

* gradle stores the origin of a dependency
* reduces traffic for already downloaded ones and not found ones
* gradle compares content-length and the last modified date in addition to
  checksum(wins in case of same version being redeployed)

## refresh

- gradle applies certain caching strategies

- snapshot versions of a dependency and dependencies with dynamic version pattern
- once resolved, they are cached for 24 hours

* can use cli option *--refresh-dependencies*

* can also change the default behavior

```groovy
configurations.cargo.resolutionStrategy {
  cacheDynamicVersion 0, 'seconds'  
}

configurations.compile.resolutionStrategy {
  cacheChangingModulesFor 0, 'seconds'  // do not cache snapshot versions
}
```
