# ch10 - the walking skeleton

- for most projects, developing the walking skeleton takes a surprising amount of effort

1. deciding what to do will flush out all sorts of questions about the
   application and its place in the world

2. automation of building, packaging, and deploying into a production-like
   environment will flush out all sorts of technical and organizational questions

- we want our skeleton test to exercise our application as close to end-to-end
  as possible, to show that the main() initializes the application correctly and
  that the components really work together

- we should start by working through the publicly visible features of the
  application (its user interface) instead of directly invoking its domain objects

## ch11 -

- use null when an argument does not matter, not used, and not easy to instantiate

```java
psf Chat UNUSED_CHAT = null;
translator.processMessage(UNUSED_CHAT, message);
```
