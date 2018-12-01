# Composite Identifiers

```java
@Embeddable
public class CompositePK implements Serializable {
  private String tutor = null;
  private String title = null;
  // default constructor
  // hashCode and equals
}

// (title, tutor, registered_students, total_students)

@Id
private CompositePK id = null;
```

## @EmbeddableId

## @IdClass
