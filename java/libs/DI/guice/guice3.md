# Guice 3

- is RI of JSR-330

- Guice enables you to build a collection of Java objects(including their dependencies)


- Terminology: Object graph, binding, module, injector

### Module

- Configuration class holds the bindings.
- Need to extends AbstractModule from Guice and just override configure method.

```java
public class AgentFinderModule extends AbstractModule{
  @Override
  protected void configure() {
    bind(AgentFinder.class).to(WebServiceAgentFinder.class);
  }
}

@Inject
public HollywoodServiceGuice(AgentFinder finder) {}
```

### Object Graph

```java
public static void main(String[] args) {
  Injector injector = Guice.createInjector(new AgentFinderModule());

  HollywoodServiceGuice hollywoodService =
          injector.getInstance(HollywoodServiceGuice.class);

  hollywoodService.getFriendlyAgents();
}
```

## Various Bindings of Guice

- Linked Bindings ( simplest form, above)
- Binding Annotations
- Instance Bindings
- @Provides methods
- Provider bindings
- Untargeted bindings
- Built-in bindings
- Just-in-time bindings

### Binding Annotations

```java
@Inject
public HollywoodService(@Named("primary") AgentFinder finder) {}

protected void configure() {
bind(AgentFinder.class).annotatedWith(Names.named("primary"))
                       .to(WebServiceAgentFinder.class);
}
```

### @Provides and Provider : Full instantiated objects

- Return a full instantiated object
- Injector figures out which object to be injected by looking at the return types

```java
public class AgentFinderModule extends AbstractModule {

  @Override
  protected void configure(){ }

  @Provides
  AgentFinder provideAgentFinder() {
    SpreadsheetAgentFinder finder =
    new SpreadsheetAgentFinder();
    finder.setType("Excel 97");
    finder.setPath("C:/temp/agents.xls");
    return finder;
  }
}
```

Number of @Provides methods can grow to be rather large, can be splitted out to their own classes.

```java
public class AgentFinderProvider implements Provider<AgentFinder> {
  @Override
  public AgentFinder get() {
    SpreadsheetAgentFinder finder = new SpreadsheetAgentFinder();
    finder.setType("Excel 97");
    finder.setPath("C:/temp/agents.xls");
    return finder;
  }
}

// bind(AgentFinder.class).toProvider(AgentFinderProvider.class);
```

## Scoping with Guice

- Scope is important, if objects end up living in the wrong space,
  they will leave longer and take up more memory than necessary.
- @RequestScope, @SessionScope, @Singleton

- Can be applied in the following ways:
  - On the class
  - Binding sequence(bind().to().in()
  - Extra annotation to @Provides contract

#### Scoping the class

- only to have one instance of the class across the entire application
- due to its nature of being injected multiple times, it has to be thread-safe.

```java
@Singleton
public class SpreadsheetAgentFinder { }
```

#### Binding Sequence

- All rules related to injection will be in one place
- Just one more method call

```java
bind(AgentFinder.class)
    .annotatedWith(Names.named("primary"))
    .to(WebServiceAgentFinder.class)
    .in(Session.class);
```

#### Scoping @Provides

```java
@Provides @Request
AgentFinder provideAgentFinder() {
  SpreadsheetAgentFinder finder = new SpreadsheetAgentFinder();
  finder.setType("Excel 97");
  finder.setPath("C:/temp/agents.xls");
  return finder;
}
```
