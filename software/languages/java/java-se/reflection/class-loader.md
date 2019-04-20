# java.lang.ClassLoader

- Class loaders define namespaces, which provides an additional degree of access control.

- subclassing the class loader is a form of reflection.
- the ability to intercede in the loading process unequivocally implies that the
  class loader is a reflective facility.

- ClassLoader#loadClass: JVM calls this methods for loading classes

### Multiple namespaces

- Although a class in the Java language is identified by its fully qualified
  name, a class object in the VM is actually identified by both its fully
  qualified name defining loader.

- you application may use multiple class loaders to load multiple classes that
  have the same name.

- two class objects that have different defining loaders are different types
  even if they are generated from the same class file.



* The JDK contains a usable concrete class loader: java.net.URLCLassLoader,
  check it out before writing your own class loader.
