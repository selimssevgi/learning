# Domain Sample 

```java
@Entity
@Table(name = "TODO")
public class Pojo {
  
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "TODO_ID")
  private Long id;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "DONE")
  private boolean done;

  @Column(name = "CREATED_AT")
  private Date createdAt;

  @JsonIgnore
  public String password;
}
```
