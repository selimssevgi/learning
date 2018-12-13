# Application using bytecode manipulation

## Hibernate

- uses javassist

- lazy initialization

- hibernate keep tracks of:

1. is the entity dirty? Have we changed any of the data?
2. What fields on the entity have been loaded?

## Spring

- uses asm

- AnnotationMetadataReadingVisitor

- When analysing the source code, it is enough to have ClassReader
- if we are not gonna change the byte code, there is no need for ClassWriter

- @Secured, @Transactional

## Mockito

## OpenJDK

- it uses asm for lambda expressions


## Other Usages

- Add logging to an application
- Find bugs
- Obfuscate so users cannot view your source code
- Perform preprocessing of code at build time
- write your own compiler or a language that runs on the JVM
- Restrict API methods for specific users
- Determine if a collection is accessed by multiple threads
- lazy load data from a database
- find differences between jars
