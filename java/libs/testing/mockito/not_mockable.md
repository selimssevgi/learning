# Mockito Limitation

Mockito cannot mock or spy the following functions:

- final classes
- final methods
- enums
- static methods
- private methods
- hashCode(), equals() methods
- anonymous classes
- primitive types


PowerMockito and PowerMock allows you to mock most of the above. However, you
should not opt for mocking private/static properties(it violates encapsulation).
Instead you should refactor the offending cod to make it testable.
