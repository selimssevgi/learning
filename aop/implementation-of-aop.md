# Implementation of AOP

- Gregor Kiczales coined the term AOP and started AspectJ, the first
  implementation of AOP.

## AspectJ

- Xerox transfered the AspectJ to the open source community at eclipse.org

- In its early implementations, AspectJ extended Java through additional
  keywords to support AOP concepts, similar to the way C++ extended C to support
  OOP concepts. As an implementation, it provided a special compiler.

- AspectJ had a close cousin: AspectWerkz. This AOP system followed the core
  AspectJ model, except that it used metadata expressed through Javadoc
  annotations, Java 5 annotations, or XML elements in place of additional
  keywords.

- In AspectJ version 5, AspectWerkz merged with AspectJ, offering developers a
  choice of technologies including a new @AspectJ (pure Java5 annotation-based)
  syntax.

## Spring AOP

- It includes an AOP system based on interceptors and the proxy design pattern.

- Earlier implementations of Spring AOP (prior to Spring 2.0) offered somewhat
  complex programming model.

- The new programming model, based on AspectJ, offers a much better programming
  experience and enables Spring users to write custom aspects without difficulty.

## Other implementation of AOP

- JBoss offers an AOP solution that includes a pointcut language similar to that
  of AspectJ.

- the AOP Alliance API is implemented in frameworks such as Guice.

- Spring used to offer a programming model based on the AOP Alliance API, but
  that model has been designated a transitional technology status due to the
  availability of the AspectJ-based model.
