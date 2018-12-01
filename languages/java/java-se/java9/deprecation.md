# Deprecation in JDK 9

## Deprecation Key Concepts

* Deprecation is:
  - notification to developers that they should migrate their code away from
    deprecated API

* Possible reasons
  - the deprecated API has something wrong with it
  - there'is a newer, better API that can be used instead
  - the deprecated API is going to be removed

## History

* Deprecation introduced in JDK 1.1 as a javadoc tag @deprecated
* Early on, massive wave of deprecations for widely varying reasons
  - dangerous APIs(Thread.destroy)
  - simple renames(AWT Component.show/hide => setVisible)
  - caused distruption, compiler warnings, fear, confusion
  - result: deprecations slowed drastically, no APIs removed

* Annotation @Deprecated introduced in Java 5
  - note capitalization
  - no change/clarification of semantics

* Has anything even been un-deprecated?
  - Yes! The System.getenv() API was in JDK 1.0
  - first sentence of its javadoc: "Obsolete"
  - implementation: threw an exception unconditionally
  - officially deprecated in 1.1(when deprecation was created)
  - fully implemented and un-deprecated in Java SE 5

* Has anything been newly introduced as deprecated?
  - Yes! Three overloads of javax.management.MBeanServer.deserialize()
  - introduced in Java SE 5, deprecated in Java SE 5!
  - JMX was a standalone JSR, with deprecated stuff, before integration into SE 5

* Confusion continued through Java 8
  - "Dont use deprecated APIs, since they might be removed"
  - "Sun/Oracle have never removed anything, and they will never"

* Wrong! We will actually remove stuff in Java 9
  - java.util.logging.LogManager.add/removePropertyChangeListener
  - java.util.jar.Pack200.Packer/Unpacker.add/removePropertyChangeListener
  - main driver was modularity, to break dependencies on Java Beans, part of the
    java.desktop module
  - also: java.awt.Component.getPeer() removed

## Deprecation Work in Java 9

- Major clarification of semantics(What deprecation means?)
- Enhancements to @Deprecated annotation
  - since : string
  - forRemoval : boolean
  - @Deprecated(since="9", forRemoval=true)
- Static analyses tool: jdeprscan
- Minor adjustments to JLS,javac,javadoc

## New Deprecation Elements

- forRemoval=boolean
  - forRemoval=true
    - deprecation is warning that the API is subject to removal in a future spec release
    - called a "terminal deprecation"
    - for Java SE, intent is that removal will occur in the next release
  - forRemoval=false
    - merely a recommendation to migrate away from this API; no current intent to remove
    - called an "ordinary deprecation"
    - pre-existing deprecations are equivalent to forRemoval=false(the default)

- since=string
  - the version when the API was deprecated; mostly informative

## Java 9 Deprecations So Far: forRemoval=false

- Boxed primitive constructors: new Integer(), new Boolean(), etc.
  - use Integer.valueOf(), Boolean.valueOf(), etc.

- java.applet
  - applets and browser plugins are (slowly) on their way out

- java.util.Observer/Observable
  - anybody ever use these?

## Java 9 Deprecations So far: forRemoval=true

- Thread.destroy()
- Thread.stop(Throwable)
  - no-arg Thread.stop() still deprecated, but not for removal

- System.runFinalizersOnExit(boolean)
  - if called with true, can cause unavoidable VM crash
  - The only fix is to remove it.

- Obsolete SecurityManager calls
  - inCheck, getInCheck, currentClassLoader(), ....
  - all vestiges of the old security mode, superseded in Java 1.2

## Future Deprecation Work

- Develop runtime analyzer: static analysis currently misses reflective access
  to deprecated APIs

* More APIs to be deprecated
  - Vector, Hashtable, Enumaration(legacy collections)
  - Optional.get(error-prone, encourages poor style)
  - Timer, TimerTask(superseded by ScheduledThreadPoolExecuter)
  - Date, Calender(superseded by java.time)
  - java.corba module?
