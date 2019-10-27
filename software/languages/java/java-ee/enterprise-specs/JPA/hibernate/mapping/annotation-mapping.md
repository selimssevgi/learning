# Annotation Mapping


```java
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EMPLOYEE_ID", nullable = false, unique = true)
  private int id;

  @Column(name = "EMPLOYEE_NAME")
  private String name;
}
```
