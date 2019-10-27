# task dependencies

- taskA can depend on taskB and taskC

```groovy
taskA.dependsOn taskB, taskC
```

### mustRunAfter

- if two tasks execute one must run after the other

### shouldRunAfter

- if two tasks execute one should run after the other
- this ignores circular dependencies
