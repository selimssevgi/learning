# Groovy Power Assert

- java is very strict regarding true/false

- only boolean variables can be tested for assertions.

- groovy take a more relaxed approach to this, allowing all objects to be
  treaded as booleans

- Groovy treats all objects as true unless:
  - the object is an empty string
  - the object is a null reference
  - the object is the zero number
  - the object is an empty collection (map, list, array, and so an)
  - the object is false Boolean
  - the object is regex matcher that fails

- the most valueable part of power assert is the detail it provides in case of failure
