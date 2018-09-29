# How Garbage Collector Works (in Oracle JVM)

- Stop the world events
- Memory fragmentation
- Throughput

## Basic Ideas

- Has a 'young generation' and an 'old generation'
- Most initial objects allocated in 'Eden space'(part of young generation)
- Young generation also has two 'survivor' spaces
  - Objects that survive a GC get moved to the survivor space
  - Only one survivor space in use at a time
  - Objects copied between survivor spaces

- Old generation is where long lived objects go to die

```shell
Young Generation | Old Generation | Permanent Generation
Eden | S0 | S1   |    Tenured     |     Permanent
```

* Permanent generation has things for java runtime(class informationA, it is
  never garbage collected)

* GC runs less frequently on old generation space

### Minor GC

- Objects are allocated into Eden space
  - When GC runs objects are copied to 'newer' survivor space
  - Objects from 'older' survivor space also copied to 'newer' survivor space
  - Survivor spaces are swapped

- Minor GC happens when young generation is full.

### Major GC

- When old generation is full, major GC happens
- Is slower than minor GC, so it runs less frequently

- Collects old and young generations (this is a "Full GC")

- JVM will eventually promote from young to old generation
  - After surviving of a certain number of garbage collects(objects are marked with number of surviving)
  - Also if survivor space is full
  - If JVM has been told to always create objects in old space(-XX:+AlwaysTenure)

**NOTE:** An object in old generation can reference to an object in young
generation. While minor GC, it has to consider this and scan 'old' space. It
prefers not to do this, cus whole things will not be different than full memory
garbage collection. It woul defeat the purpose of having different generations.

### Card Table

- Each write to a reference to a young object goes through a write barrier
- Write barrier triggers code in the JVM, and this code updates an entry in table
- the write barrier updates a card table entry
- One entry per 512 bytes of memory
- Minor GC scans table looking for the areas that contain references
- Load that memory and follow the reference
