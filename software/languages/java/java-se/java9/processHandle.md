# ProcessHandle

- java.lang.Process represents native process created from Java

- java.lang.ProcessHandle represents any native on the OS

- Can kill, watch, and get info about native process on OS

- Process#toHandle
- ProcessHandle.of(123); // pid
- PorcessHandle#info -> ProcessHandle.Info

## How to get your own pid

- before java 9

```java
Long.parseLong(
  ManagementFactory
    .getRuntimeMXBean()
    .getName()
    .split("@")[0]
);
```

- with java 9

```java
ProcessHandle.current().pid();
ProcessHandle.current().destroyForcibly(); // ISE: destroy of current process not allowed

ProcessHandle.allProcesses()
  .map(ProcessHandle::info)
  .forEach(System.out::println);
```
