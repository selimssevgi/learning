# Designing for testability

- Sometimes we cannot mock out the external dependencies because of testing an
  unfriendly design.

* Following Java constructs go up against mocking the testing impediments:

- Constructors initialize testing impediments
- Class-level variable declaration and initialization
- The private methods
- The final methods
- The static methods
- The final classes
- Use of new
- Static variable declaration and initialization
- Static initialization blocks

Do not instantiate dependencies in the constructor; the dependencies may exhibit
testing impediments and make the class nontestable. Instead of instantiating the
dependencies in the constructor, pass the real implementations to the
constructor or the setter method of the code under the test.

Do not instantiate variables at the class level.

Do not hide testing impediments in private methods.(protected methods can be
overridden to bypass the testing impediments)

Do not hide testing impediments in final methods(cannot be overridden or stubbed). 
Extract the content of a final method to a protected method.
