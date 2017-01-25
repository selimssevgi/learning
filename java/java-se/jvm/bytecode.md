# Bytecode

- Bytecode is an intermediate representation of a program.
- Halfway between human readable source and machine code.
- Bytecode is produced by javac from Java source code files
- Some high-level language features have been compiled away and dont appear in
  bytecode. (for, while are gone, turned into bytecode branch instructions.)

- Each opcode is represented by a signle byte (hence the name bytecode)
- Bytecode is an abstract representation, not "machine code for an imaginary CPU"
- Bytecode can be further compiled to machine code, usually "just in time"


## Disassembling a class
```java
$ javap -c -p Test.class
// dissamble Test class, also show private methods
```


```java
0: aload_0
1: invokespecial #1 // Method java/lang/Object."<init>":()V
4: return
```

- Numbers in front code represents the offset into the bytecode stream since the
  start of method.

- #1 16bit(2 bytes) index in the constant pool

- invokespecial (calls superclass constructor)
- invokespecial also used to call private methods

## Opcodes

- Each opcode is denoted by a single-byte value.
- Currently, only around 200 are used(at most 255 possible)

- *Name:* general name for the type of opcode
- *Args:* i, look up index in constant pool, i1,i2 -> "make 16bit index"

- Load and store opcodes: store, store, getfield, putfield, ldc(load constant),
  dload(doubleload),

- Arithmetic opcodes: add, sub, div, mul, (cast: i2d)

- Execution control opcodes: if, goto, jsr(jumpsubroutine), ret, tableswitch,
  loopupswitch

- Invocation opcodes: invokestatic, invokevirtual, invokeinterface,
  invokespecial, invokedynamic

*NOTE:* A regular call is virtual. The exact method to be called is looked up at
runtime using standard Java rules of method overriding. invokespecial call dont
take overrides into account. For superclass constructors and private methods
there is no need to trigger override rules.

- Platform opcodes: new, monitorenter, monitorexit
