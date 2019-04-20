# Changes in Java 9

## Incompatible changes in JDK 9

- Encapsulate most JDK-internal APIs
- Change the binary structure of the JRE and JDK
- Remove a small number of supported, JCP-standard APIs
- Remove the endorsed-standards override and extension mechanisms
- Java EE modules not resolved by default
- New version-string format

## What can you do to prepare for JDK 9?

- Check code for usages of JDK-internal APIs with jdeps
- Check code that might be sensitive to the version change
- If you develop tools then check code for a dependency on rt.jar or tools.jar
  or the runtime-image layout
- Get familar with new features like multi-release JARs and the ability to
  compile to older releases(--release 8)
