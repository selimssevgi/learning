# JVM parameters

- If a switch starts with -X: it is a nonstandard, may not be portable
- If a switch starts with -XX: extended switch, not for causel use, performance-relevant
- Some switches are Boolean in effect and take a + or - in front of them
- Other switches take a parameter, such as -XX=CompileThreshold=1000

Switch                  | Effect
------------------------|------------------------------------
-Xms2m                  | Inital size of heap(default 2MB)
-Xmx64m                 | Max size of heap(default 64)
-Xmn#m                  | Size of young generation in heap
-XX:-DisableExplicitGC  | Prevent calls to System.gc(), no effect
