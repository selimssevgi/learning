# Weaving

- is the process of applying aspects to a target object to create a new proxied object

- the weaving can take place at several points in the target object's lifetime:

1. compile time

aspects are woven in when the target class is compiled. This requires a special
compiler. AspectJ's weaving compiler weaves aspects this way.

2. class load time

aspects are woven in when the target class is loaded into the JVM. This requires
a special ClassLoader that enhances the target class's bytecode before the class
is introduced into the application. AspectJ 5's load-time weaving (LWT) support
weaves aspects this way.

3. runtime

aspects are woven in sometime during the execution of the application.
Typically, an AOP container dynamically generates a proxy object that delegates
to the target object while weaving in the aspects. This is how Spring AOP
aspects are woven.
