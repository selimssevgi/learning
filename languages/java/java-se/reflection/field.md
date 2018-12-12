# Accessing Field Reflectively

- One usage of field access is serialization of object

- Java serialization is not the best option because:
  - requires Serializable interface, cannot add to third party code,
  - cannot share with other environment as it is unique to Java

* Example reasoning on using reflection for XML serialization:

- Mandate support of a toXML method by each serializable object
  - third-party and jdk classes cannot be serialized in this way

- Use a 3rd party serialization lib that uses preprocessors, generated code, or
  source-to-source translation to enable serialization.
  - steep learning curve
  - extra code for each serializable class

- Use a 3rd party serialization lib that requires maintainance of mapping files to enable serialization.
  - bulky and require hand-editing
  - keep up to date with source code
  - leave programming language to modify mapping classes


```shell
// public member, including inherited ones
Field getField(String name)
Field[] getFields()

// alll fields by class
Field getDeclaredField(Strign name)
Field[] getDeclaredFields()
```

- Object values can be get or set.
- Primitives are wrapped when get or set.
- There are getter and setter for primitives types as well if we know the field is a primitive already.
