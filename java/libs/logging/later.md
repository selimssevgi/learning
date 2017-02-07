One additional feature that method handles provide is the ability to determine the
current class from a static context. If you’ve ever written logging code (such as for
log4j) that looked like this,

Logger lgr = LoggerFactory.getLogger(MyClass.class);

you know that this code is fragile. If it’s refactored to move into a superclass or sub-
class, the explicit class name would cause problems. With Java 7, however, you can
write this:

Logger lgr = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

In this code, the lookupClass() expression can be thought of as an equivalent to get-
Class() , which can be used in a static context. This is particularly useful in situations
such as dealing with logging frameworks, which typically have a logger per user class
