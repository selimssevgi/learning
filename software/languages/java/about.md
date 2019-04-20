# Some Clarifications

- Java Language: statically typed, OO programming language, human readable.

- Java Platform: a software that provides runtime environment. JVM, .class files.

- JLS and VMSpec are in separation now. No reference from each other.

- The link between the language and the platform is the shared definition of the
  class file format.(the .class file)

### is Java compiled or interpreted language?

- Source code(.java) compiled(javac) into bytecode(.class).
- Bytecode being interpreted by JVM and also JIT(another compilation)
- JVM bytecode is halfway house between human-readable source and machine code.
- Bytecode is really a form of intermediate language(IL).
- Java source code compilation is different than C/C++ code compilation.
- javac is different than gcc in some sense.
- The real compiler is JIT.
- Because of JIT, java system might be described as "dynamically compiled".


###### Effort involved in implementing new functionality in different ways

-                  Library | x
-          Tool capability | xx
-          Syntactic Sugar | xxxxx
-     New language feature | xxxxxxxx
- Class file format change | xxxxxxxxxxxxx
-           New VM feature | xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

* Syntactic sugar - Underscores in numbers(J7)
* Small new language feature - try-with-resources(J7)
* Class file format change - Annotations(J5)
* New JVM feature - invokedynamic(J7)

*Syntactic Sugar:* something already exist. syntax form is redundant. is removed
from computers representation of program(desugared). Small amount of work,
involve changes only to compiler(javac).

The source code for java itself released under GPLv2. This was around the time
of release J6. So Java 7 is the first version of Java to be developed under an
open source software licence. Primary focus for open source development of java
platform is the OpenJDK project.
