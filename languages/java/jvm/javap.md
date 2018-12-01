# javap tool

- Oracle JVM ships with a tool called javap.
- Very handy for peeking inside and disassembling class files.
- To see what methods a class declares

```shell
$ javap Test.class
// just show default, public, protected methods

$ javap -p Test.class
// also show private methods

$ javap -s Test.class
// show method signatures with type descriptors

$ javap -v Test.class
// show the information in the constant pool
```

- JVM uses slightly different form for method signatures internally than the
  human-readable form displayed by javap.

Descriptor  | Type
------------|--------
B           | byte 
C           | char (a 16-bit Unicode character)
D           | double
F           | float
I           | int
J           | long
L(typename) | Reference type (Ljava/lang/String; for a String)
S           | short
Z           | boolean
[           | array of
V           | void

## Contant Pool Entries

Name               | Description
-------------------|-----
Class              | A class contant. Points the name of the class (as a Utf8 entry)
Fieldref           | A field. Point at Class and NameAndType of this field
Methodref          | A method. Points at Class and NameAndType of this field
InterfaceMethodref | An interface method. Points at Class and NameAndType of this field
String             | String constant. Points at Utf8 entry that holds the characters
Integer            | An integer constant (4 bytes)
Float              | An float-point constant (4 bytes)
Long               | A long constant (8 bytes)
Double             | A double-precision floating-point constant (8 bytes)
NameAndType        | Describes a name and type pair. points at Utf8 that holds type of descriptor for the type
Utf8               | A stream of bytes representing  Utf8-encoded characters
InvokeDynamic      | New in Java 7
MethodHandle       | New in Java 7: describes a MethodHandle constant
MethodType         | New in Java 7: describes a MethodType constant
