# 55 New Features

- by SimonRitter

## Modularity/Jigsaw

- Standard class libraries modularised
  - rt.jar now 94 modules

- Most internal APIs now encapsulated
  - sun.misc.Unsafe

- Modular source code
  - JDK source code re-organised to support modules

## jlink

- allows you to build a runtime which only contains the modules that you need
  for your application

- stripped down version of rt fro given application

- java.base@9.0

- version numbering  for information purposes only
- it is not a goal of the module system to solve the version-selection problem

## Factory Method for Collections

- Static factory methods on List, Set, and Map interfaces
  - create compact, immutable instances
  - 0 to 10 element overloaded versions
  - plus varargs version for arbitary number of elements


```java
Set<String> set = new HashSet<>();
set.add("a");
set.add("b");
set.add("c");
set = Collections.unmodifiableSet(set);

// java9
Set<String> set = Set.of("a", "b", "c");
```

## Stream Enhancements

- dropWhile()/takeWhile()
  - like skip/limit but uses Predicat rather than number

- Improved iterate
  - enables a stream to be more like a for loop

- Parallel Files.lines()
  - memory mapped, divided on line break boundary

- Stream from Optional
  - Stream of zero or one elements

## Multi-Release Jar Files

- Multiple Java release-specific class file in a single archive
- Enhance jar tool to create multiple-release files
- Support multi-release jar files in the JRE
  - Classloader
  - JarFile API
- Enhance other tools
  - javac, javap, jdeps, etc
- Also, modular jar files

- works from java9 onwards, java 9 version of class, java 10 version of class

## REPL: jshell

## Concurrency Updates

- Reactive streams publish-subscribe framework
- Asynchronous, non-blocking

## Enhanced Deprecation

- We have @deprecated and @Deprecated
  0 used to cover many situations

- new methods in Deprecated annotation
  - boolean, forRemoval()
    - will this ever be removed?
  - String since()
    - JDK version when this was deprecated

- jdeprscan command to produce report

## Milling Project Coin

- Underscore no longer valid as identifier
  - ready fro use in Lambdas

- Private methods in interfaces
  - multiple inheritance of behaviour makes this logical

- Effectively final variables in try-with-resources
  - variables from outside try block

- Allow @SafeVarargs on private instance methods
  - in addition to constructors, final and static methods

- Diamond operator with anonymous classes
  - Extending type inference further

## Keeping up with standards

- Unicode
- SHA-3
- HTML5 for javadoc

## Default Collector: G1

- Designed as low-pause collector
- Concurrent class unloading

## Better String Performance

- Compact strings
  - improve the space efficiency of the String class

## New Version String Format

- Old
  - Limited update release/Critical path update
  - JDK 8u121 or jdk1.8.0_u121
  - Which has more patches, JDK 7u55 or JDK 7u60?

- New
  - JDK $MAJOR.#MINOR.$SECURITY.$PATCH
  - easy to understand by humans and apps
  - semantic versioning

## JDK/JRE File Structure

- Pre-JDK 9
  - bin
  - jre (bin, lib(rt.jar), ..)
  - lib (tools.jar)

- JDK 9
  - bin
  - conf
  - lib

## Incubator Modules

- Develop APIs without making them part of the standard
  - at least not straight away

- Allow developers to "kick the tyres"
  - not always possible to get a new API right first time

- Move from incubator to full module
  - Becomes part of the standard

- JDK 9 only has one incubaor: HTTP/2
-
