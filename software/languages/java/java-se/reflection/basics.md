# Reflection Basics

- Reflection is the ability of a runnig program
  -to examine itself and its software environment
  - to change what it does depending on what it finds

- a program needs to have a representation of itself in order to perform self-examination
- this representation (information) is called **metadata**

- in an OO world, metada is organized into objects, called **metadataobjects**

- the runtime self-examimation of the metadaobjects is called **instrospection**

- there are 3 techniques that a reflection API can use to facilitate behavior change:

1. direct metaobject modification
2. operations for using metada (such as dynamic method invocation)
3. intercession

** Java supplies a rich set of operations for using metadata and just a few
important intercession capabilities. In addition, Java avoid many complications
by not allowing direct metaobject modification.


- 3 issues that have far impeded the broad use of reflection:

1. security
2. code complexity
3. runtime performance


## Example Scenario

- there many objects in your app, and those objects have 'setColor' method with
  exact signature. However, they do not implement a common interface.

1. Discover a 'setColor' method supported by the component
2. Call that 'setColor' method with the desired color

* If you would be in the control of all the components, you could refactor into
  implementing a common interface

* Writing adapter, implemting a common interface, delegating to object. Lots of
  extra classes to maintain, and creation of lots of object at runtime.

* Using of 'intanceof', casting, coupling with concrete type, maintaince.


```java
// these two methods are each a form of introspection
Method setColor = obj.getClass().getMethod("setColor", Color.class);
setColor.invoke(obj, color); // dynamic invocation
```

- metaobjects are part of a program's self-representation (Class, Method)

