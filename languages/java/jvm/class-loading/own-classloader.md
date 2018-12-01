# Writing Our Own Classloader

- Will not load all classes
  - delegate to the system classloader

- if the parent can't load
  - load the class bytes from the database
  - use ClassLoader's defineClass method to load the class


```java
// classes:
// id | class(bytecode) | className
psvm(String[] args) {
  try {
    DatabaseClassLoader dcl = new DatabaseClassLoader("jdbc://")
    Class clazz = dcl.findClass("com.selimssevgi.Test");
    MyInterface mi = (MyInterface) clazz.newInstance();
  } catch(Exception ex) {
    //
  }
}
```

```java
public class DatabaseClassLoader extends ClassLoader {
  private ClassLoader parent;
  private String connectionStr;

  public DatabaseClassLoader(String connectionStr) {
    this(ClassLoader.getSystemClassLoader(), connectionStr);
  }

  public DatabaseClassLoader(ClassLoader parent, String connectionStr) {
    super(parent);
    this.parent = parent;
    this.connectionStr = connectionStr;
  }

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    try {
      return parent.loadClass(name);
    } catch (ClassNotFoundException cnfe) {
      try {
        byte[] bytes = loadFromDb(name);
        return defineClass(name, bytes, 0, bytes.length);
      } catch (Exception ex) {
        throw new ClassNotFoundException("Unable to load class " + name, ex);
      }
    }
  }

  private byte[] loadFromDb(String name) {
    // load from database
    return new byte[0];
  }
}

```
