# Monitoring Garbage Collectors

## MXBeans

- There is a Java MX Bean for the garbage collector
- Name of collectors
- Number of collections
- Time of collections

```java
// can be used to see which java version uses which GC as default
List<GarbageCollectorMXBean> collectorMXBeans =
  ManagementFactory.getGarbageCollectorMXBeans();

collectorMXBeans.forEach(bean -> {
  System.out.println(bean.getCollectionCount());
  System.out.println(bean.getCollectionTime());
  System.out.println(bean.getName());
  System.out.println(Arrays.toString(bean.getMemoryPoolNames()));
});
```

## JStat

- command line utility

```shell
# jstat -option <pid> <interval> <count>
jps # get pid of java process

jstat -gcutil 16899
```

## VisualVM

- VisualGC is a plugin for visualVM gives much more info for GC

```shell
jvisualvm
```
