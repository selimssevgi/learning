# configMaps

- configMaps can be accessed from a pod using:

1. env variables (key/value)
2. configMap volume (access as files)


- you can configure apps by
    - passing cli arguments to containers/pods
    - setting custom env variables for each container
    - mounting config file

```yaml
spec:
    containers:
    - image: luksa/fortune:env
        env:
        - name: INTERVAL
          value: "30"
```

- env variables hardcoded in pod definition means you need to have separate pod
  definitions for your diff deployment envs


- k8s allows separating config options into a separate object called ConfigMap
- the content of config map is passed to containers as:
    - either env variables 
    - or as files in a volume
