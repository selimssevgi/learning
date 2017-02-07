# Dependency Injection

- JSR-330(javax.inject) official standart for Java
- JSR-299 enterprise java, JEE 6, Contexts and Dependency Injection, CDI
- Guice(3) framework is the reference implementation for JSR-330

- A form of Inversion of Control(IoC)
- Is a technique in which object gets its dependencies given to it, as opposed
  to having to construct them itself.

* Some benefits to using DI:
  - loosely coupled codebase
  - easier to test codebase
  - easier to read codebase

### Reasoning

#### Inversion of Control

- The flow of program logic is usually controlled by a cental piece of
  functionality.(non-IoC)

- Using IoC, this "cental control" design principle is inverted.
- Also known as Hollywood Principle: "Don't call us, we'll call you"
- Another piece of code(initial thread of control) calls your code, rather than
  your code calling it.

- Application logic has control over which event handler to invoke.(text-based UI)
- GUI framework has control over which event handler will be executed.

#### Dependency Injection

- IoC is too generic, "what aspect of the control are they inverting?"

- The process of finding your dependencies is outside the direct control of
  currently executing code.

- Guice is DI framework with a built-in IoC container.

- An IoC container can be seen as a runtime executin enviroment.

- Many developers used variations on the 'Factory and Service Locator' patterns.
  All of which were a type of IoC.

- Injection is not the only way to break dependency, 'service locatar' is
  another way.

```java
public static List<Agent> getFriendlyAgents() {
  AgentFinder finder = new SpreadsheetAgentFinder(); // LOCK-IN!!
  List<Agent> agents = finder.findAllAgents();
  List<Agent> friendlyAgents = filterAgents(agents, "Java Developers");
  return friendlyAgents;
}
```

* With Factory and Service Locator pattern

```java
public List<Agent> getFriendlyAgents(String agentFinderType) {
AgentFinderFactory factory = AgentFinderFactory.getInstance();
AgentFinder finder = factory.getAgentFinder(agentFinderType); // Factory Pattern
List<Agent> agents = finder.findAllAgents();
List<Agent> friendlyAgents = filterAgents(agents, "Java Developers");
return friendlyAgents;
}
```

Problems with above code:

- A lookup referenece(String) instead of real implementation(AgentFinder).
- Method still contains the code to find its dependency, which ideally isn't its core concern.

* With DI

```java
public static List<Agent> emailFriendlyAgents(AgentFinder finder) { // injected
  List<Agent> agents = finder.findAllAgents();
  List<Agent> friendlyAgents =
  filterAgents(agents, "Java Developers");
  return friendlyAgents;
}
```

- The method looks clean and readable.
- But the problem is that: 'Who is gonna do the injection'?

- This is where a DI framework with IoC container can help out.
- DI framework is a runtime wrapper around the code, injecting dependencies needed.
- DI framework can do this at any point the code need a dependency.
- The framework is able to do this, IoC container holds the dependencies ready for code to use at runtime.

```java
@Inject
public static List<Agent> emailFriendlyAgents(AgentFinder finder) { // injected
  List<Agent> agents = finder.findAllAgents();
  List<Agent> friendlyAgents =
  filterAgents(agents, "Java Developers");
  return friendlyAgents;
}
```

### Benefits of DI

- *Loose coupling:* Method is no longer dependent on a specific type of AgentFinder to perform its work.

- *Testability:* A stub/mock could be injected easily.

- *Greater cohesion:* No longer dealing with factories etc, it executes only the business logic.

- *Reusable components:* Someone else just could use it, and inject any implementation of AgentFinder they want.

- *Lighter code:* Code reduced significantly, more clean and readable.
