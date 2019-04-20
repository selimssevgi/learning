# Load Different Version of Same Class


```java

psvm(String[] args) {
  try {
    URL url1 = new URL("file:///some-location.jar");
    URLCLassLoader ucl1 = new URLCLassLoader(new URL[]{ url1 });
    Class clazz1 = Class.forName("com.selimssevgi.TestClass", true, ucl1);
    TestInterface ti1 = (TestInterface) clazz1.newInstance();

    URL url2 = new URL("file:///some-other-location.jar");
    URLCLassLoader ucl2 = new URLCLassLoader(new URL[]{ url2 });
    Class clazz2 = Class.forName("com.selimssevgi.TestClass", true, ucl2);
    TestInterface ti2 = (TestInterface) clazz2.newInstance();

    soutf("clazz1 == clazz2?  %b\n", clazz1 == clazz2); // false
    soutf("ti1.class == ti2.class?  %b\n", ti1.getClass == ti2.getClass); // false
  } catch(Exception ex) {}
}
```

- Because we are using different class loaders, so caching in one of the class
  loaders does not affect the other one.

- This enables isolation between class loaders
