# Groovy Features

* Which are not (yet) in Java

- GroovyBeans - beans made simpler
- Safe navigation of null object using the ?.operator
- Elvis operator, an even shorter way of writing if/else constructs
- Groovy strings, a more powerful string abstraction(GString, ${})
- Function literals (a.k.a closures), passing around functions(Java8,9)
- Native support for regular expressions
- XML handling made easy

## GroovyBeans

- Much like JavaBeans
- Omit explicit getters and setters
- Provide auto constructors
- Reference member variables using dot notation
- @Immutable

```groovy
class Character {
  private int strength
  private int wisdom
}

def pc = new Character(strength: 10, wisdom: 15)
pc.strength = 18
println "STR {" + pc.strength + "] WIS [" + pc.wisdom + "]"
```

## Safe-dereference Operator(?.)

```groovy
List<Person> people = [null, new Person(name:"Gweneth")]
for (Person person: people) {
  if (person != null) {         // Explicit null checking
    println person.getName()
  }
}
```

```groovy
people = [null, new Person(name:"Gweneth")]
for (Person person: people) {
  println person?.name
}
```

## The Elvis Operator(?:)

```java
String agentStatus = "Active";
String status = agentStatus != null ? agentStatus : "Inactive";
```

```groovy
String agentStatus = "Active"
String status = agentStatus ? agentStatus : "Inactive" // no null checking

// even shorter removing repeated variable
String status = agentStates ?: "Inactive"
```

## Function Literals

```groovy
class StringUtils {
  static String sayHello(String name) {
    if (name == "Martijn" || name == "Ben")
      "Hello author " + name + "!"
    else
      "Hello reader " + name + "!"
  }
}

println StringUtils.sayHello("Bob")
```

```groovy
def sayHello = {
    name ->
       if (name == "Martijn" || name == "Ben")
          "Hello author " + name + "!"
        else
          "Hello reader " + name + "!"
}

println sayHello("Martijn")
```

## First class support for regex

Method | Description and Java equivalent
-------|--------------------------------
~      | Creates a pattern (creates a compiled Java Pattern)
=~     | Creates a matcher(creates a java Matcher object)
==~    | Evaluates the string(effectivelly calls Java's match() on the Pattern)

