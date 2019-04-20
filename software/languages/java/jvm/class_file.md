# Class File

- A .class file defines a type for the JVM.
- It has fields, methods, inheritance information, annotations and other metadata.
- The class file format is well-described by the standards.
- Any language that wants to run on JVM must adhere class file format standards.

## Loading
Class loaders does the loading.

## Linking

- Verification: Lots of checks are done for performance reasons. They enable the
  skipping of runtime checks, thus making the interpreted code run faster.

- Preparation: allocation memory, getting static variables in the class ready to initialized

- Resolution: VM checks every type referred to by the new class file is known to
  the runtime(If not, load them too). After all additional types are loaded,
  located and resolved, VM can initialize the class. Any static variable being
  initialized and static blocks being executed. After this phase the class is
  fully loaded and ready to go.(now we have Class object.)

