# alternatives


- qualitifiers at development time

- alternatives at deploment time

- depending on the environment

- @Alternative

### for testing

```java
public IsbnGenerator implements NumberGenerator {}

@Alternative
public MockGenerator implements NumberGenerator {}

@Alternative // acts as an alternative for both @Thirteen and @Eighteen
@Thirteen
@Eighteen
public MockGenerator implements NumberGenerator {}
```

- at this point, for injection point nothing changes, it will use @Defualt for injection

- can use a different beans.xml for testing for activation of alternatives

```xml
<beans>

  <alternatives>
    <class>full-package-class</class>
  </alternatives>
</beans>
```
