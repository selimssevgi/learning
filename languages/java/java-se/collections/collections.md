# Collections

## Arrays
An array is an indexed collection of fixed number of homogenous data elements.
Main advantage of arrays is that we can represent multiple values by using single variable,
so that readability of program will be improved.

### Limitation of Arrays
- Arrays are fixed in size. Once we create an array,
  there is no chance of increasing or decreasing the size based on our requirement.
  Due to this, to use array concept compulsary we should know the size in advance,
  which may always not be possible.

- Array can hold only homogenous data type elements.

```java
Student[] s = new Student[1000];
s[0] = new Student();
s[1] = new Consumer(); // !!CE: incompatible type error.
```

- We can solve this problem by using Object type array.

```java
Object[] s = new Object[1000];
s[0] = new Student();
s[1] = new Consumer();
```

- Array concept is not implemented based on some standart data structure,
  and hence the xxxx data support not available, for every requirement we have
  write the code explicitly, which increases complexity of the program.

*To overcome above problems of array, we should go for Collection concept.*

## Collections

- Collections are growable in nature, we can increase or decrease the size.

- Collections can hold both homogenous and heterogenous elements.

- Every Collection class is implemented by on some standart data stucture. Hence
  for every requirement xxxx data support available, being a programmer we are
  responsible to use those methods, and we are not responsible to implement those methods.

### Differences between Array and Collection

Properties           | Array                             | Collection
---------------------|-----------------------------------|--------------------
Size                 | Fixed size                        | Growable
Memory wise          | Not recommended                   | Recommended
Performance wise     | Recommended                       | Not recommended
Element variety      | Homogenous                        | Homo & Heterogenous
Required work        | Too much                          | Ready to use methods
Element type         | Primitives & Objects              | Just objects


*Collection:*
If we want to represent a group of indivual objects as a single entity, then we should go for collection.

*Collection Framework:*
It contains several classes and interfaces which can be used to represent a group of indivicual objects.

C++ : container -> collection, STL(standard template library) -> collection framework

### 9 Key Interfaces of Collection Framework
1. Collection
2. List
3. Set
4. SortedSet
5. NavigableSet
6. Queue
7. Map
8. SortedMap
9. NavigableMap

### Collection(I) - Java 1.2

- If we want to represent a group of indiviaul objects as a single entity,
  then we should go for collection.

- Collection Interface defines the most common methods, which are applicable
  for any collection object.

- In general Collection Interface is considered as root interface of CF.
- There is no concreate class which implements Collection(I) directly.

**Difference between Collection & Collections**

Collection is an interface, if we want to represent a group of indivial object...

Collections is a utility class, represent in java.util package to define several
utility methods for Collection objects, like sorting, searching etc.

### List(I) - Java 1.2

- It is the child interface of Collection(I).
- If we want to represent a group of indivual object as a single entity, where
  duplicates are allowed, and insertion order must be preserved. go for List(I).

```shell
Collection(I) <- List(I)
                  - ArrayList
                  - LinkedList
                  - Vector  - 1.0 Legacy classes
                    - Stack - 1.0 Legacy classes
```

In 1.2 Vector and Stack classes are re-engineered to implement List(I).

### Set(I) - Java 1.2

- It is a child interface of Collection(I).
- If we want to represent a group of indiviual object as a single entity, where
  duplicates are not allowed, and insertion order is not preserved. go for Set(I).

```shell
Collection(I) <- Set(I)
                  - HashSet - 1.2V
                  - LinkedHashSet - 1.4V
```

#### SortedSet(I) - Java 1.2

- It is a child interface of Set(I).
- If we want to represent a group of indivial objects as single entity, where
  duplicates are not allowed, and all objects should be inserted according to some sorting order.

##### NavigableSet(I) - Java 1.6

- It is a child interface of SortedSet(I).
- It contains several methods for navigation purposes.

Collection(I) <- Set(I) <- SortedSet(I) <- NavigableSet(I) <- TreeSet

TreeSet is there since Java 1.2, but it was re-engineered after NavigableSet(I)

**Differences between List and Set**
- L: Duplicates are allowed
  S: Duplicates are not allowed

- L: Insertion order preserved.
  S: Insertion order not preserved.

### Queue(I) - Java 1.5(All Subs)

- It is a child interface of Collection(I).
- If we want to represent a group of indivual objects 'prior to processing',
  then we should go for Queue(I).

- Usually queque follows FIFO order. But based on our requirement, we can
  implement our own priority order also.

**Example:** Before sending all mail IDs we have to store in some data structure,
  in which order we added mail IDs, and in same order only mail should be delivered.

```shell
Collection(I) <- Queue(I) <- PriorityQueue
                          <- BlockingQueue
                             - PriorityBlockingQueue
                             - LinkedBlockingQueue
```

All above interfaces(Collection,List,Set,SortedSet,NavigableSet,Queue) are meant
for representing indiviaul objects. If we want to represent a group of object as key-value pairs
then we should go for map.

## Map(I)

- Map is not a child interface of Collection(I).
- If we want to represent a group of objects as key-value pairs, then go for Map.
- Both key and value are Objects only.
- Duplicate keys are not allowed, but values can be duplicated.

```shell
Map(I) <- HashMap(1.2) <- LinkedHashMap(1.4)
       <- WeakHashMap
       <- IdentityHashMap(1.4)
       <- Hashtable <- Properties (Java 1.0 - Legacy)
```

### SortedMap(I)

- It is a child interface of Map(I).
- If we want to represent a key-value pairs according to same 'sorting order of key',
  then we should go SortedMap.
- In SortedMap sorting should be based on key, but not based on value.

#### NavigableMap(I)

- It is a child interface of SortedMap(I).
- It defines several methods for 'navigation purposes'.

Map(1.2) <- SortedMap(1.2) <- NavigableMap(1.6) <- TreeMap(1.2)


**The following are legacy characters in Collection Framework:**
- Enumeration(I)
- Dictionary(AC)
- Vector(C)
- Stack(C)
- Hashtable(C)
- Properties(C)

## Collection(I)
Defines most common methods which are applicable for any collection object.

```java
boolean add(Object o);
boolean addAll(Collection c);
boolean remove(Object o);
boolean removeAll(Collection c);
boolean removeIf(Predicate filter)
boolean contains(Object o);
boolean containsAll(Collection c);
boolean retainAll(Collection c);
boolean isEmpty();
void clear();
int size();
Object[] toArray();
toArray(T[] a);
Iterator iterator();
```

There is no concreate class which implements Collection(I) directly.

## List(I)
- We can preserve in a such order via index.
- We can differentiate duplicate object by using index.
- Index plays very important role in List.

List(I) defines following specifics methods:

```java
void add(int index, Object o);
boolean addAll(int index, Collection c);
Object get(int index);
Object remove(int index);
Object set(int index, Object o); // returns old object
int indexOf(Object o); // returns index of first occurrence of o
int lastIndexOf(Object o); // returns index of last occurrence of o
ListIterator listIterator();
ListIterator listIterator(int fromIndex);
List subList(int fromIndex, int toIndex);
```

Except TreeSet and TreeMap in CF heterogenous elements are allowed. In Tree
structure they should comparable therefore must be same type.

### ArrayList
- The underlying structure is resizeable array or growable array.
- Duplicates are allowed.
- Insertion order is preserved.
- Heterogenous objects are allowed.
- null insertion is possible.

#### Constructors
```java
ArrayList<T> l = new ArrayList<>();
```

- Creates an empty arraylist object with initial capacity, which is 10.
- Once ArrayList reaches its capacity, then a new arraylist object will be created,
  with initial capacity = currentcapacity * 3/2 + 1

- Each time increasing capacity internally is not efficient.

```java
ArrayList<T> l = new ArrayList<>(int initialCapacity);
```
Creates an empty arraylist object with the specified initial capacity.

```java
ArrayList<T> l = new ArrayList<>(Collection c);
```
Creates an equalivent arraylist object for the given collection.

Usually we can use collections to hold and transfer objects from one location to another location(container)
to provide support for this requirement every collection class default implements Serializable(I), and Clonable(I).

**RandomAccess(I)**

Only ArrayList and Vector classes implement RandomAccess(I), so that any random element we can access with the same speed.

RandomAccess(I) represent in java.util package, and doesnt contain any methods.
It is a 'marker interface'. Requireability will be provided by the JVM.

*ArrayList is the best choice* if our frequent operation is retrievel operation.
Because ArrayList implements RandomAccess(I).
*ArrayList is the worst choice* if our frequent operation is insertion or deletion in the middle.


**Differences between ArrayList and Vector**

Property          | ArrayList  | Vector
------------------|------------|------------------
Synchronized      | Is not     | Is synchronized
Thread-safe       | Is not     | Is thread-safe
Performance       | High       | Low
Java version      | 1.2        | 1.0

**How to get synchronized version ArrayList object:**

By the default ArrayList is not synchronized. But we can get synchronized version
of ArrayList object by using synchronizedList method of Collections.

```java
ArrayList al = new ArrayList();
List synchronizedList = Collections.synchronizedList(al); // List l
```

Similarly we can get synchronized version Set and Map object by using following methods of Collections class.

```java
public static Set synchronizedSet(Set s);
public static Map synchronizedMap(Map s);
```

### LinkedList(C)
- Underlying data structure is doubly-linked list.
- Insertion order is preserved.
- Duplicate object are allowed.
- Heterogenous objects are allowed.
- null insertion is possible.
- LinkedList implements Serializable(I), Cloneable(I), but not RandomAccess(I).
- LinkedList is the best choice if our frequent operation is insertion or deletion in the middle.
- LinkedList is the worst choice if our frequent operation is retrievel operation.

#### Constructors
```java
// Creates an empty linkedlist object.
LinkedList ll = new LinkedList();

// Creates an equalient of the given Collection.
LinkedList ll = new LinkedList(Collection c);
```


LinkedList class specific methods, usually we can use linkedList to develop stacks and queues
to provide support for this requirement, LinkedList(C) defines following methods:

```java
void addFirst(Object o);
void addLast(Object o)
Object getFirst();
Object getLast();
Object removeFirst();
Object removeLast();
```


**Differences between ArrayList and LinkedList**

- ArrayList  is better choice if our frequent operation is retrievel operation.
- LinkedList is better choice if our frequent operation is insertion or deletion in the middle.
- ArrayList  is worse  choice if our frequent operation is insertion or deletion in the middle.(Cus internally several shift operations performed)
- LinkedList is worse  choice if our frequent operation is retrievel operation.

- In ArrayList  elements will be stored in consequtive memory locations, hence retrievel op will become easy.
- In LinkedList elements wont be stored in consequtive memory locations, hence retrievel op will become difficult.

### Vector
- Underlying data structure is resizeable array or growable array.
- Insertion order is preserved.
- Duplicates are allowed.
- Heterogenous object are allowed.
- null insertion is possible.
- It implements Serializeable, Cloneable, RandomAccess interfaces.
- Every method representing in Vector is synchronized, hence Vector object is thread-safe.

#### Constructors

```java
// initial capacity = 10
// new capacity = capacity * 2
Vector v = new Vector();

// Creates an empty Vector object with the specified initial capacity
Vector v = new Vector(int initialCapacity);

Vector v = new Vector(int initialCapacity, int capacityIncrement); // start with 1000, 2000 may be too much

// This constructor mean for inter-conversion between collection objects.
Vector v = new Vector(Collection c);
```


Vector is a legacy class, methods names long and with 'element'

Vector specific methods :

```java
addElement(Object o);
removeElement(Object o);
removeElementAt(int index);
removeAllElements();
elementAt(int index);
firstElement();
lastElement();
Enumeration elements();
```

#### Stack -> Vector
- It is a child class of Vector.
- It is a specially designed class for LIFO.

#### Constructors

```java
Stack s = new Stack();

// Stack specific methods:
Object push(Object o);
Object pop();
Object peek();
boolean empty();
int search(Object o); // returns offset if the element is available, otherwise return -1
```

Offset: is opposite of the index, it says how far it is from the top of the Stack

```shell
Index  from top : 2, 1, 0
Offset from top : 1, 2, 3
```

## Three Cursors of Java
- If you want to get objects one by one from the collections, then we should go for cursor.
- There are three types of cursors available in java:
  - Enumeration
  - Iterator
  - ListIterator

analogy: a box of mangos. box -> collection, mangos -> object
as a human beings you will have to eat them one by one, not putting your head in the box and eat them randomly.

### Enumeration
We can use an Enumeration to get object one by one from legacy collection object.
We can create an Enumeration object by using elements() method of Vector class.

```java
public Enumeration elements();
Enumeration e = v.elements();

// Methods:
public boolean hasMoreElements();
public Object nextElement();
```


#### Limitation of Enumeration(1.0V)
1. We can apply Enumeration concept only for legacy concept, and it is not an universal cursor. (Not available except Vector and Stack)
2. By using Enumeration we can get only read access, and we can not perform remove operation.

To overcome above limitation we should go for 'Iterator'.

### Iterator(I)
- We can apply Iterator concept for any collection object, and hence it is universal cursor.
- By using Iterator we can perform both read and remove operation.

We can create an Iterator object by using 'iterator()' method Collection(I).
```java
public Iterator iterator();
Iterator itr = c.iterator(); // c is any Collection object.

// Iterator methods:
public boolean hasNext();
public Object next();

// this is the extra method, which not in Enumeration
public void remove(Object o);
```

#### Limitation of Iterator
1. By using Enumeration and Iterator we can always move only forward direction,
   and cannot move backward direction. These are single direction cursors, but not bi-directional cursor.
2. By using Iterator we can perform only read and remove operation, and cannot
   perform replacement and addition of new objects.

To overcome above limitations we should go for 'ListIterator'.

### ListIterator(I)
- is a child interface of Iterator, and hence all methods presenting in Iterator by default available to ListIterator.
- By using ListIterator we can move either forward or backward direction, and hence it is bi-directional cursor.
- By using ListIterator we can perform replacement and addition of new object in addition to read and remove operations.

We can create ListIterator by using 'listIterator()' method of List(I).

```java
public ListIterator listIterator();

ListIterator ltr = l.listIterator(); // l is any List object.

// ListIterator defines the following 9 methods:

// forward movement
public boolean hasNext();
public Object  next();
public int     nextIndex();

// backward movement
public boolean hasPrevious();
public Object  previous();
public int     previousIndex();

// modification methods / extra operations
public void remove();
public void add(Object o);
public void set(Object o); // replace operation
```

The most powerful cursor is ListIterator. But its limitation is that it is
applicable only for List objects.

## Set(I)
- is a child interface of Collection(I)
- If we want to represnt a group of indiviual object as a signle entity,
  where duplication is not allowed, and insertion order is not preserved.

- Set(I) doesnt contain any new methods, and we have to use only Collection(I) methods.

### HashSet(C)
- Underlying data structure is hash table.
- Duplication is not allowed.
- Insertion order is not preserved.
- null insertion is possible, but only once.
- All objects are inserted based on hashcode
- Heterogenous object are allowed.
- Implements Serializeable(I), Cloneable(I)
- Is the best choice if our frequent operation is search operation.

In HashSet duplicates are not allowed, if we are trying to insert duplicates,
then we wont get any compile or runtime error, and add method simply return false.

```java
hashSet.add("java"); // return true
hashSet.add("java"); // no error, returns false
```

#### Constructors
HashSet contructors is same as other collection class contains '*Hash*'.

```java
// Creates an empty HashSet object with the default initial capacity 16,
// and the default fill ratio(load factor) is 0.75
HashSet h = new HashSet();

// Creates an empty HashSet object with the specified initial capacity,
// and the default fill ratio is 0.75
HashSet h = new HashSet(int initialCapacity);

HashSet h = new HashSet(int initialCapacity, float loadFactor);
HashSet h = new HashSet(Collection c);
```

**Fill Ratio or Load Factor**

After filling how much ratio the new hashset object will be created.
This ratio is called fill ratio or load factor.
Increse the capacity when 0.75 of the collection is filled.

### LinkedHashSet(C) - java 1.4
- is a child class of HashSet
- is exactly same as HashSet(including contructors and methods)

**except the following differences:**

- Underlying data structure is hashtable + linkedlist
- Insertion order is preserved!(thanks to linkedlist)
- Introduces in 1.4 version(HashSet is in 1.2 version)

In general we can use LinkedHashSet to develop cache based applications,
where duplicates are not allowed, and the insertion order is preserved.

### SortedSet(I)
- is a child interface of Set(I).
- If we want to represent a group of indiviual object
  according to some sorting order w/o duplicates, then we should go for SortedSet(I)
- SortedSet(I) defines the following the specific method:

```java
Object first();
Object last();
SortedSet headSet(Object o); // whose elements are < o
SortedSet tailSet(Object o); // whose elements are >= o
SortedSet subSet(Object o1, Object o2); // whose elements are >= o1 and < o2
Comparator comparator(); // if we are using default comparator, it returns null.
```

```shell
Default natural sorting order : For number is ascending
                                For string is alphabetical
```

### TreeSet(C)
- Underlying data structure is balanced tree
- Duplicates are not allowed
- Insertion order is not preserved.
- Heterogenous types are not allowed. otherwise ClassCastException
- null insertion is possible. only once
- Implements Serializable(I), Cloneable(I) but not RandomAccess(I)
- All objects will be inserted based some sorting order.
  it may be a default natural order or customized sorting order.

#### Constructors
```java
// Creates an empty TreeSet object
// where the elements will be inserted according to default natural sorting order.
TreeSet t = new TreeSet();

// Creates an empty TreeSet object where the elements will be inserted
// according to customized sorting order specified by the Comparator object.
TreeSet t = new TreeSet(Comparator c);

TreeSet t = new TreeSet(Collection c);
TreeSet t = new TreeSet(SortedSet s);
```

**null acceptance**

1. For non-empty TreeSet if we are trying to insert null, then we will get NPE.
2. For empty Treeset as a first element null is allowed, after inserting that null,
   if we are trying any other then we will get RE: NullPointerException
   Because null is not comparable with other type.

*NOTE:* Until 1.6 version null is allowed as a first element to the empty TreeSet,
but 1.7 version onwards null is not allowed even as a first element.

```java
TreeSet t = new TreeSet();
t.add(new StringBuffer("A"));
t.add(new StringBuffer("Z"));
t.add(new StringBuffer("B"));
sout(t);

// RE: ClassCastException:
// java.langStringBuffer cannot be cast to java.lang.Comparable
```

If we are depending on default natural sorting order, compalsary the objects
should be homogenous and comparable. Otherwise we will get RE: ClassCastException

An object is said to be comparable if and only if corresponding class implelemts Comparable(I).

String class and all wrapper classes already implement Comparable(I).

But StringBuffer doesnot implement Comparable(I). Hence we got ClassCastException in the above example.

## Comparable(I)
- It is present in java.lang package
- It contains only one method: compareTo();

```java
public int compareTo(Object o);

obj1.compareTo(obj2);
```

- returns -1 if obj1 has to come before obj2 // negative value
- returns +1 if obj1 has to come after  obj2 // positive value
- returns  0 if obj1 and obj2 are equal

*Note:* If d.n.s.o is not available or if we are not satisfied with natural sorting order
then we can go customized sorting by using Comparator.

- Comparable meant for default natural sortig order
- Comparator meant for customized sorting order.

## Comparator
- Present in java.util package
- Defines two methods: compare() and equals()

- public int compare(Object obj1, Object obj2);
- returns negative if obj1 has to come before obj2
- returns positive if obj1 has to come after  obj2
- returns zero     if obj1 and obj2 are equal

- public boolean equals(Object o);

Whenever we are implementing Comparator(I), compalsery we should provide implementation for compare method.

And we are not required implementation for equals method, because it is already
available to our class from Object class through inheretence.

### Varios possible implementation of compare method

```java
@Override
public int compare(Object o1, Object o2) {
  Integer i1 = (Integer) o1;
  Integer i2 = (Integer) o2;

  return i1.compareTo(i2); // default natural sorting order, ascending
  return i2.compareTo(i1); // descending order
  return -i2.compareTo(i1); // ascending order
  return -i1.compareTo(i2); // descending order
  return +1; // insertion order, keeps the duplicate too
  return -1; // reverse of insertion order
  return  0; // only first element will be inserted, remaining will be treated as duplicates
}
```

Ex: write a program to insert string object into treeset
where all elements should be inserted according to reverse of alphabetical order.

Ex: write a program to insert stringbuffer object into treeset
where sorting order is alphabetical order. Supply customized sorting order,

*Note:* If we are depending on the default natural sorting order,
compulsary the objects should be homogenous and comparable, otherwise we will get RE: CCE
If we are defining our own sorting by Comparator(I) then objects need not be comparable and homogenous,
that is we can add heterogenous non-null objects also.

EX: write a program to insert string and stringbuffer object into treeset,
where sorting order is increasing length order.
if two object are having same length, then consider their alphabetical order.

**Comparable vs Comparator**

1. For pre-defined comparable classes(like String), default natural sorting order is already available.
   If we are not satified with the d.n.s.o then we can define our own sorting order by using comparator.

2. For pre-defined non-comparable classes(like StringBuffer), d.n.s.o is not already available,
   we can define our own sorting by using Comparator(I).

3. For our own classes like Employee, the person who is writing the class is responsible to define d.n.s.o by implementing Comparable(I).
   The person who is using our class, if he is not satified with the d.n.s.o then we can define his own sorting by using Comparator(I).

## Comparasion of Comparable(I) & Comparator(I)
1. Comparable is meant for d.n.s.o,
   comparator is meant for customized sorting order.

2. Comparable is present java.lang package,
   Comparator is present java.util package

3. Comparable defines only one method: compareTo(Object o);
   Comparator defines two methods(and some default methods): compare(Object o1, Object o2); equals(Object o);

4. Comparable implementations : String and all wrapper classes,
   Comparator implementations : Collator and RuleBasedCollator

## Comparasion of Set(I) implemented classes

Properties                | HashSet       | LinkedHashSet          | TreeSet
--------------------------|---------------|------------------------|------------
Underlying data structure | Hashtable     | Hashtable + LinkedList | Balanced tree
Duplicate objects         | not allowed   | not allowed            | not allowed
Insertion order           | not preserved | preserved              | not preserved
Sorting order             | N.A           | N.A                    | Applicable
Heterogenous object       | Allowed       | Allowed                | Not allowed
null acceptance           | Allowed       | Allowed                | Not allowed


## Map(I)
- Map(I) is 'not' child of Collection(I).
- If we want to represent a group of objects as key-value pairs, then go for Map.
- Both keys and values are objects only.
- Duplicate keys are not allowed, but values can be duplicated.
- Each key-value pair is called 'Entry'. Hence Map is considered as a collection of Entry objects.

```shell
Key   Value
100   Java    -> Entry
101   Oracle
102   Android
```

### Map(I) methods

```java
public Object put(Object key, Object value);
```

- To add one key-value pair to the map.
- If the key is already present, then old value will be replaced with the new value,
  and returns the old value, or null if not present.

```java
m.put(100, "java");   // returns null
m.put(101, "sun");    // returns null
m.put(101, "oracle"); // return "sun"

void putAll(Map m);
Object get(Object key);
Object remove(Object key);
boolean containsKey(Object key);
boolean containsValue(Object value);
boolean isEmpty();
int size();
void clear();

// collection views of map
Set keySet();        // no duplicates, it is set
Collection values(); // could have duplicates, is collection
Set entrySet();      // no duplicates, it is set
```

#### Entry(I)
- A map is a key-value pairs, and each key-value pair is called an entry.
  Hence map is considered as a collection of entry objects.
- Without existing Map object, there is no chance of existing Entry object,
  hence Entry(I) is defined inside Map(I).

```java
interface Map{
  interface Entry {
    // we can apply only on Entry object: m.entrySet();
    Object getKey();
    Object getValue();
    Object setValue(); // returns old value
  }
}
```

##### HashMap(C)
- Underlying data structure is hashtable
- Insertion order is not preserved, and it is based on hashcode of keys.
- Duplicates keys are not allowed, but values can duplicates.
- Heterogenous objects are allowed for both key and value.
- null is allowed for key(only once),
- null is allowed for value(any number of times)
- HashMap implements Serializable(I), Cloneable(I), but not RandomAccess(I)
- HashMap is the best choice if our frequent operation is search operation.

###### Constructors
```java
// Creates a empty hashmap object with default initial capacity of 16,
// default load factor of 0.75
HashMap hm = new HashMap();

HashMap hm = new HashMap(int initialCapacity);
HashMap hm = new HashMap(int initialCapacity, float loadFactor);
HashMap hm = new HashMap(Map m);
```

**Comparasion of HashMap and Hashtable**

1. HashMap   methods are not synchronized.
   Hashtable methods are synchronized.

2. HashMap   , multiple threads are allowed to operate on HashMap object, and hence it is not thread-safe.
   Hashtable , at a time only one thread is allowed to operate on Hashtable object, hence it is thread-safe.

3. HashMap   has relatively high performance, cus threads are not required to wait.
   Hashtable has relatively low  performance, cus threads are required to wait to operate on Hashtable object.

4. HashMap   allows null for both keys and values.
   Hashtable doesnt allow for any null. otherwise NPE.

5. HashMap   is introduced in Java 1.2V.
   Hashtable is introduced in Java 1.0V, is legacy.

We can get synchronized version of HashMap object as follows:

```java
HashMap m = new HashMap();               // not synchronized
Map m1 = Collections.synchronizedMap(m); // synchronized
```

### LinkedHashMap(C)
- It is a child class of HashMap
- It is exactly same as HashMap(including methods and contructors)

**except following differences:**

- Underlying data structure is Hashtable + LinkedList(Hibrit data structure)
- Insertion order is preserved.
- Java 1.4 version.

*Note:* LinkedHashSet and LinkedHashMap are commonly used for developing cache based application.

### IdentityHashMap(C)
- It is exactly same as HasmMap(including methods and constructor),

**except the following difference:**

- In the case of normal Hashmap, JVM will use .equals method to identify duplicates keys,
  which is meant for content comparison.

```java
HashMap<Integer,String> m = new HashMap<>();
Integer i1 = new Integer(10);
Integer i2 = new Integer(10);
m.put(i1, "java");
m.put(i2, "python");
sout(m); // {10=python}
```

- But in case of IdentityHashMap, JVM will use == operator to identify duplicate keys,
  which is meant for reference comparison.(Address comparison)

```java
IdentityHashMap<Integer,String> m = new IdentityHashMap<>();
Integer i1 = new Integer(10);
Integer i2 = new Integer(10);
m.put(i1, "java");
m.put(i2, "python");
sout(m); // {10=python, 10=java}
```

### WeakHashMap(C)
- It is exactly same as HashMap, 

**except the following differences:**

- In case of HashMap even though object doesnt have any references,
  it is not eligiable for gc if it is associated with HashMap,
  HashMap dominates garbage collecter.

- But in case of WeakHashMap, if object doesnt contain any references,
  it is eligible for gc even though the object is associated with WeakHashMap,
  that is gc dominates WeakHashMap.

### SortedMap(I)
- is a child interface of Map(I)
- If we want to represent key-value pairs according to some sorting order of keys.
- Sorting is based on the key. But not based on the value.

SortedMap defines the following specific methods:

```java
Object firstKey();
Object lastKey();
SortedMap headMap(Object key);              // entries before this
SortedMap tailMap(Object key);              // entries after this with this
SortedMap subMap(Object key1, Object key2); // from key1 to except key2
Comparator comparator();                    // returns null if using default one
```

### TreeMap(C) -> SortedMap(I)
- Underlying data structure is red-black tree
- Insertion order is preserved. and it is based on some sorting order of keys.
- Duplicate keys are not allowed, but duplicates values are allowed.
- If we are depending on default natural sorting order then the keys should homogenous and comparable. otherwise RE: CCE.
- If we are defining our own sorting by Comparator(I), then the key need not be homogenous and comparable.
  we can take heterogenous and non-comparable objects also.
- Whether we are depending on d.n.s.o or customized sorting order,
  there are no restrictions for values, can be heterogenous and non-comparable objects.

- null acceptance is with the same rules as TreeSet
- but for values, we can use null any number of times, there is no restriction.

#### Constructors

```java
TreeMap t = new TreeMap();
TreeMap t = new TreeMap(Comparator c);
TreeMap t = new TreeMap(SortedMap s);
TreeMap t = new TreeMap(Map m);
```

### Hashtable
- the underlying data structure for hashtable is hashtable
- insertion order is not preserved, and it is based on hashcode of keys.
- Duplicates keys are not allowed, and values can be duplicated,
- Heterogenous objects are allowed for both keys and values.
- null is not allowed for both key and value, Otherwise RE: NPE
- implements Serializable(I), Cloneable(I) but not RandomAccess(I)>
- Every method presenting in hastable is snyhcronized, and hence Hashtable is thread-safe.
- Hashtable is the best choice if our frequent operation is search operation.

#### Constructors

```java
// default capacity: 11, load factor: 0.75
Hashtable h = new Hashtable();

Hashtable h = new Hashtable(int initialCapacity);
Hashtable h = new Hashtable(int initialCapacity, float loadFactor);
Hashtable h = new Hashtable(Map m);
```

Ex : Temp has int field, and it is used as hashcode of the object.

```java
public static void main(String[] args) {
  Hashtable<Temp, String> h = new Hashtable<>();
  // we have 11 buckets in hastable by default
  h.put(new Temp(5),  "A"); // goes 5th bucket in the hashtable
  h.put(new Temp(2),  "B"); // goes 2th bucket in the hashtable
  h.put(new Temp(6),  "C"); // goes 6th bucket in the hashtable
  h.put(new Temp(15), "D"); // there is no 15th bucket, 15 % 11 = 4th bucket
  h.put(new Temp(23), "E"); // there is no 23rd bucket, 23 % 11 = 2nd bucket
  h.put(new Temp(16), "F"); // there is no 16th bucket, 16 % 11 = 5th bucket, next to the earlier one
  //h.put(null, "G"); RE: NPE
  //h.put(new Temp(71), null); // RE:NPE
  System.out.println(h); // prints from top to bottom,right to left
  // {6=C, 16=F, 5=A, 15=D, 2=B, 23=E}
}
```

If we have change hashCode of Temp class as, { return i % 9; }, their buckets and output will change.

## Properties
- In our program if anything which changes frequently(like username, passwords, mailId etc)
  are not recommended to hard-code in java program. Because if there is any change,
  to reflect that change recomplation, rebuild, redeploy application are required.
  Even sometimes server restart is also required, which creates a big business impact on the customer.
- We can overcome this problem by using properties file.Such a type of variable things
  we have to configure in the properties file.
- From that properties file we have to read into java program, we can use those properties.
- The main advantage of this approach is if there is a change in properties file,
  to reflect that change just redeployment is enough, which wont create any business impact on the client.
- We can use java properties object to hold properties, which are coming from properties file.

- In normal Map(like HashMap, Hashtable, TreeMap) key and value can be any type.
  but in case of properties key and value should be String type.

##### Constructor
```java
Properties p = new Properties();

// Properties methods:
String setProperty(String pname, String pvalue); // to set a new property, same as map.put
String getProperty(String pname);
Enumaration propertyNames();
void load(InputStream is); // to load properties from file to object
void store(OutputStream os, String comment); // to store object to properties file
```

## Queue(I) - java 1.5
- 1.5 version enhancements
- It is a child interface of Collection(I)
- If we want to present a group of indiviual object 'prior to processing', then we should go for Queue.
- Ex: before sending sms, all mobile numbers we have to store in some data structure,
  in which order we added numbers, in the same order only the message should be sent.
  For this FIFO requirement, Queue is the best choice.
- Usually Queue follows FIFO order, but based on our requirement we can implement
  our own priority order also(PriorityQueue)
- From 1.5 version onwards LinkedList(C) also implements Queue(I).
- LinkedList based implemention of Queue(I) always follows FIFO.

### Queue(I) specific methods:

```java
boolean offer(Object o); // to add an object into the que
boolean add(Object o);   // add if capacity is enough, otherwise raise exception
Object peek();     // returns head element of the que, if que is empty, returns null
Object element();  // return head element of the que, if que is empty, raise RE: NoSuchElementException
Object pull();     // to remove and return head element of the que, if que is empty, returns null
Object remove();   // to remove and return head element of the que, if que is empty, raise RE: NoSuchElementException
```

### PriorityQueue(C)
- If we want to represent a group of indivial objects 'prior to processing'
  according to some priority, then we should go for PriorityQueue
- The priority can be default natural sorting order or customized sorting order
- Insertion order is not preserved, and it is based on some priority.
- Duplicate objects are not allowed.
- If we are depending d.n.s.o compulsary the objects should be homogenous and comparable,
  otherwise we will get RE: CCE.
- If we are defining our own sorting by using Comparator, then objects need not be homogenous and comparable.
- null is not allowed. Even as a first element.

#### Constructors

```java
// creates with default capacity 11, using d.n.s.o
PriorityQueue pq = new PriorityQueue();

PriorityQueue pq = new PriorityQueue(int initialCapacity);
PriorityQueue pq = new PriorityQueue(int initialCapacity, Comparator c);
PriorityQueue pq = new PriorityQueue(Sorted s);
PriorityQueue pq = new PriorityQueue(Collection c);
```

*Note:* Some platforms wont provide proper support thread prorities and propirityQueues.
Output may not be as expected.

## 1.6 V enhancements CF
- As a part of 1.6V the following two concept in CF were introduced:
  1. NavigableSet(I)
  2. NavigableMap(I)

### NavigableSet(I)
- It is a child interface of SortedSet(I)
- it defines several methods for navigation purposes.

Collection(I) <- Set(I) <- SortedSet(I) <- NavigableSet(I) <- TreeSet(C)

Analogy: flight times, the flight before 10am?

### NavigableSet defines the following methods:
- floor(e);
it returns highest element which is <= e
- lower(e);
it returns highest element which is < e
-ceiling(e);
it returns  lowest element which is >= e
- higher(e);
it returns  lowest element which is > e
- pollFirst();
remove and return first element
- pollLast();
remove and return last element
descendingSet();
it returns NavigableSet in reverse order

## NavigableMap(I)
- is a child interface of SortedMap(I)
- it defines several methods for navigation purposes.

Map(I) <- SortedMap(I) <- NavigableMap(I) <- TreeMap(C)

### NavigableMap(I) defines the following methods:
- floorKey(e)
- lowerKey(e);
- ceilingKey(e);
- higherKey(e);
- pollFirstEntry();
- pollLastEntry();
- descendingMap();

# Utility Class: Collections
- Collections(C) defines several utility methods for collections object.
  like sorting, searching, reversing etc.

- SortedSet and SortedMap provides sorting for Set and Map objects.

## Sorting elements of List
Collections(C) defines the following two sort methods:

- public static void sort(List l);
  to sort based on d.n.s.o
  List must be homogenous, otherwise RE: CCE
  List should not contain null, otherwise RE: NPE

- public static void sort(List l, Comparator c);
  to sort based on customized sorting order

## Searching elements of List
Collections defines the following binarySearch methods:

- public static int binarySearch(List l, Object target);
  If the list sorted according to d.n.s.o, then we have use this method.

- public static int binarySearch(List l, Object target, Comparator c);
  if the list sorted according to customuzed sorting order, then we have to use this method.

**Conclusions:**

1. The above search methods internally will use binary search algorithm.
2. Successfull search returns index,
3. Unsuccessful search returns insertion point.
4. Insertion point is the location where we can place the target element in the sorted list.
   Insertion point start from -1,-2,-3... so on.
5. Before calling BinarySearch method, compalsory the list should be sorted,
   otherwise we will get unpredictable results.
6. If the list is sorted according to comparator,
   then at the time of search operation also we have to pass same comparator object,
   otherwise we will get unpredicted results.

```shell
Insertion Point =  -1 -2 -3 -4 -5 -6
List            =  [1, 2, 3, 4, 5]
Index order     =   0  1  2  3  4

Successful result range   =  0 to 4
Unsuccessful result range = -6 to -1
Total result range        = -6 to 4

In case of list of n elements:
Successful result range   =  0 to n-1
Unsuccessful result range = -(n+1) to -1
Total result range        = -(n+1) to n-1
```

## Reversing elements of list
Collections(C) defines the following reserve method:

- public static void reverse(List l);

##! reverse(List l) vs reverseOrder(Comparator c)
```java
// to get the reverser comparator
Comparator c1 = Collections.reverseOrder(c2);

// if c2 is ascending, then c1 will be descending
// if c2 is descending, then c2 will be ascending
```


## Arrays(C)
- It is an utility class to define several utility methods for array objects,

### Sorting elements of array
Arrays(C) defines the following sort methods:

- public static void sort(primitive[] p); // default natural sorting order

- public static void sort(Object[] o); // default natural sorting order

- public static void sort(Object[] o, Comparator c); // customized sorting order

*Note:*
We can sort primitive arrays only based on default natural sorting order.
Whereas we can sort object arrays either based on d.n.s.o or based on customized sorting order.

### Sorting elements of array
Arrays(C) defines the following binarySearch methods:

- public static int binarySearch(primitive[] p, primitive target);

- public static int binarySearch(Object[] a, Object target);

- public static int binarySearch(Object[] a, Object target, Comparator c);

Notes:
All rules of Arrays(C) binarySearch methods are exactly same as Collections(C) binarySearch methods.

### Conversion of array to list

- public static List asList(Object[] a);

Strictly speaking this method wont create a dependent list object,
for the existing array we are getting list view.

```java
String[] s = {"A", "B", "C"};
List l = Arrays.asList(s); o
```

By using array reference if we perform any changes, automatically that change will be reflected to the list.
By using list  reference if we perform any changes, automatically that change will be reflected to the array.

By using list reference we cannot perform any operations which varies the size.
Otherwise we will get runtime exception saying UnsupportedOperationException

```java
l.add("M");
l.remove(1); // both will throw UnsupportedOperationException

l.set(1, "N"); // replace operation is valid
```

By using list reference we are not allowed to replace with the heterogenous objects,
otherwise we will get runtime exception: ArrayStoreException

l.set(1, new Integer(10)); RE: ArrayStoreException
