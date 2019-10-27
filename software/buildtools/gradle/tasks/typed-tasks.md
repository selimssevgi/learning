# typed task

- we may have a complex logic in a task, we would like to reuse in other tasks

- copying files?
- zipping files?

- gradle has many built-in typed tasks

- use a typed-task and just configure properties

```groovy
task copyImages (type: Copy){
  from 'src'
  into 'dest'
}
```

- replace $resourceRefName in web.xml with 'jdbc/JacketDB'

```groovy
task copyConfig (type: Copy){
  include 'web.xml'
  from 'src'
  into 'config'
  expand {
    [resourceRefName: 'jdbc/JacketDB']
  }
}
```


