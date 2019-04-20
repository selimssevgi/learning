# jmap

- Shows memory maps of Java processes


```java
$ jsp
$ jmap -histo <pid> | head -30
num     #instances         #bytes  class name
----------------------------------------------
  1:          3058        2383424  [I

$ jmap -histo:live <pid> | head -30
// dont show garbage
```
