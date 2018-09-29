# Java Reference Classes

- Java has always had 'strong' references
  - Object not GC'd until references are released

- Other types of references are available(since JDK 1.2)
  - 'Special' class in java.lang.ref package(JVM knows about them)
  - Soft, Weak, Phantom

- WeakHashMap, ReferenceQueue

## Reference Rules

- Strong > Soft > Weak > Phantom (SSWP)

- Object not GC if there is a strong reference
- Can be GC'd if there is Soft, Weak, or Phantom reference

- Soft will be collected if there is memory pressure
- Weak will be collected immediately
- Phantom references different to the other two
  - Cannot retrieve the object through a phantom reference

## Using Reference Types


```java
Person person = new Person();
WeakReference<Person> wPerson = new WeakReference<>(person);

Person p1 = wPerson.get(); // point the initial person object
System.out.println(p1);

person = null;
p1 = null;
// assuming not GC
Person p2 = wPerson.get(); // can access the initial person object again
System.out.println(p2);    // still same object reference

p2 = null;
System.gc();
Person p3 = wPerson.get(); // initial person obj is GC'd, will return null
System.out.println(p3);    // prints null
```

## Usages of Reference Types

- WeakReference: associate meta data with another type, WeakHashMap

- SoftReference: can be used for caching
  - no control over the cache
  - managed by GC
  - may not be the best way

- PhantomReference: interaction with the GC, when the object is collected?
- Instead of finalize, you could use PhantomReference

### WeakHashMap

- If a class is marked as final, and we can't derive that class

- Like a HashMap, except the key is actually a weak reference
- Value is the object's 'meta data'

- When object has no more strong references 
  - the key is released
  - 'meta data' goes away


```java
public class WeakHashMapEx {
  public static void main(String[] args) throws InterruptedException {
    WeakHashMap<Person, PersonMetaData> whm = new WeakHashMap<>();
    Person person = new Person();
    whm.put(person, new PersonMetaData());
    PersonMetaData personMetaData = whm.get(person);
    System.out.println(personMetaData);

    person = null;
    System.gc();
    Thread.sleep(1);
    if (whm.containsValue(personMetaData)) {
      System.out.println("Still contains key");
    } else {
      System.out.println("Key gone"); // key should be GC'd
    }
  }
}

final class Person {

}

class PersonMetaData {
  Date date;

  public PersonMetaData() {
    this.date = new Date();
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("PersonMetaData{");
    sb.append("date=").append(date);
    sb.append('}');
    return sb.toString();
  }
}
```

### ReferenceQueue

- Pass a reference queue to constructor when creating the reference object
  - Optional except for PhantomReference

- References types enqueued to ReferenceQueue
- Useful when you want to associate some cleanup mechanism with an object

- When all strong references cleared, Reference is object is added to the reference queue

- ReferenceQueue has poll and remove methods
  - poll returns immediately
  - remove has a timeout(blocks until it has a reference)
  - Both remove object from the queue

- Can be used to attach clean up code, extend reference type
- Dequeue object from the queue, calls its 'clean up' method

```java
public class ReferenceQueueEx {
  public static void main(String[] args) throws IOException {
    Person p = new Person();
    PersonCleaner pc = new PersonCleaner();
    ReferenceQueue<Person> prq = new ReferenceQueue<>();
    PersonWeakReference weakReference = new PersonWeakReference(p, prq, pc);

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    executorService.execute(() -> {
      PersonWeakReference reference = null;
      try {
        reference = (PersonWeakReference) prq.remove();
        reference.clean();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    p = null;
    System.gc();

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Press any key to continue");
    bufferedReader.readLine();
    executorService.shutdown();
  }
}

class PersonCleaner {
  public void clean() {
    System.out.println("Cleaned");
  }
}

class PersonWeakReference extends WeakReference<Person> {
  private final PersonCleaner cleaner;

  public PersonWeakReference(Person referent,
                             ReferenceQueue<? super Person> q,
                             PersonCleaner cleaner) {
    super(referent, q);
    this.cleaner = cleaner;
  }

  public void clean() {
    cleaner.clean();
  }
}
```

### PhantomReference

- With WeakReference and SoftReference when we call the get method on the
  reference type, we get back a strong reference to the underlying object

- PhantomReference does not work in that way

- Wrap strong reference in PhantomReference, then call get, we get null always

- Can be used as a replacement for finalize methods

- Finalizers have issues:
  - can be expensive(will wait one GC cycle more, as system will have the reference)
  - not sure when they will be called

- cleanup is managed by us instead of garbage collector

```java
public class PhantomReferenceEx {
  public static void main(String[] args) {
    ReferenceQueue<Person> referenceQueue = new ReferenceQueue<>();
    List<Person> people = new ArrayList<>();
    List<FinalizePerson> finalizers = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      Person p = new Person();
      people.add(p);
      finalizers.add(new FinalizePerson(p, referenceQueue));
    }

    people = null;
    System.gc();

    finalizers.forEach(ref -> System.out.println(ref.isEnqueued()));
    Reference<? extends Person> refFromQue;
    while ((refFromQue = referenceQueue.poll()) != null) {
      ((FinalizePerson) refFromQue).cleanup();
    }

  }
}

class FinalizePerson extends PhantomReference<Person> {

  public FinalizePerson(Person referent, ReferenceQueue<? super Person> q) {
    super(referent, q);
  }

  public void cleanup() {
    System.out.println("person is finalizing resource");
  }
}
```
