# Validation API Usage

- @Size can be applied to String, Collection, Map and array properties.
- Message attribute is common to all of them.


```java
public class User {

  @NotNull(message = "Name cannot be null")
  private String name;

  @AssertTrue(message = "Working must be true")
  private boolean working;

  @Size(min = 10, max = 200, message = "About Me must be between 20 and 200 characters")
  private String aboutMe;

  @Max(value = 99, message = "Age should not be greater than 99")
  @Min(value = 18, message = "Age should be greater than 18")
  private int age;

  public static void main(String[] args) {
    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    Validator validator = vf.getValidator();

    User user = new User();
    user.setName("Selim");
    user.setAge(15);
    user.setAboutMe("Something about me");
    user.setWorking(false);

    Set<ConstraintViolation<User>> violations = validator.validate(user);

    violations.forEach(v -> System.out.println(v.getMessage()));
  }

  // Standard getters and setters
}
```
