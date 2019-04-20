# Types of Garbage Collection

- Do nothing(never run, no freeing memory)
- Reference Counting
- Mark and Sweep(in two phases, leaves fragmented memory behind)
- Copying(works with MaS, fixes the fragmented memory)
- Generational(once a survivor, always a survivor, not check that object again)
- Incremental(no memory checking all the time)

* Can have a mixture of types in a single Garbage Collector

## Reference Counting

- methods calls when allocating/freeing memory
  - client can forget to call those methods, result in memory leaks
  - can call decrement methods while object is still in use(not ideal)
- COM for example had AddRef and Release calls for objects
- When count hits zero object can be freed
- Problems with circular references

* Two objects referencing each other, without any external references. They are
  garbage, but because they are referencing each other, count is not zero.

## Mark and Sweep

- 'mark' phase that identifies the objects that are still in use
- 'sweep' phase to remove unused objects
- 'compact' phase to compact the memory

- Starts from a Root set of references(in stack, a point in live memory)
- Follow that references and mark them as alive objects
- Cycles dont affect the GC, because they do not have external references
- After sweeping there will be fragments in the memory, it will compact that
- JVM has the access the physicall address of the memory

## Copying

- it still has typical mark and sweep phase

- Uses different 'spaces' to manage memory

- 'fromspace' and 'tospace'

- when 'fromspace' gets full, the GC runs
- in the sweep phase, the alive objects are moved from 'fromspace' to 'tospace'
- sweep and compact phase happen at the same time
- finally 'fromspace' is cleared
- 'tospace' and 'fromspace' are now swapped

## Generational Collectors

- maintain diffeent generations for memory
- long living objects 'promoted' to a different generation
- for a given definition of 'long'
- there could be any number of generations(in java there are two(young, old))

- once an object survives, it is promoted to a different generation
- GC will sweep through the young generations more often
