# Mark and Sweep

- Simplest garbage collection algorithm
- It was first to be developed


- Pauses all running program threads
- Walks through the tree of references from the (known) life objects
- Marks as live any object found en route
- Everything left is garbage and can be collected(swept)
- Swept memory is returned to JVM, not necessarily to OS


## Areas of Memory

- *Eden:* the area of heap where all objects are initially allocated, and for
  many objects this will be the only part of memory that they ever reside in.

- *Survivor:* Two survivor spaces(one split in half). Objects survived from Eden
  are moved here. There are referred to as From and To.

- *Tenured:*  a.k.a old generation. Old enough object are moved here from
  Survivor space. Tenured memory isnot collected during young collections.

- *PermGen:* Memory for internal structures is allocated. Such as definition of
  classes. Is strictly part of heap proper, ordinary objects dont ever end up here.


* There are two types of collections:

### Young Collections

- Triggered when Eden is full.
Attempts to clear only "young" spaces(Eden and survivor).

- All live young objects found during marking phase are moved:

  - Sufficiently old ones(survived enough previous GV runs) goes into tenured.
  - All other young, live objects go into the empty survivor space.

- At the end, Eden and recently vacated survivor space are ready to be
  overridden and reused, they contain nothing but garbage.

### Full Collections

- When young collection cannot promote an object to tenured(due to lack of
  space), a full collection is triggered.

### Safepoints

- GC cannot take place without at least a short pause of all application threads
- But threads cannot be stopped at any arbitrary time for GC
- There are certain special times when GC can take place -- called safepoints.
