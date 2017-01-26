# Grovvy Syntax

- Almost all Java syntax is available in groovy


## Default Imports

- groovy.lang.\*
- groovy.util.\*
- java.lang.\*
- java.io.\*
- java.math.BigDecimal
- java.math.BigInteger
- java.net.\*
- java.util.\*

```groovy
import java.math.*;
```

```groovy
x = new Date();
x = 1; 

// also optionally
Date x = new Date();

// declaring a static type and assigning a wrong type
double y = 3.14;
y = new Date(); // Exception thrown
```

## Scopes

- *Binding Scope:* is the global scope for the script.


```groovy
String hello = "Hello!";
globalHello  = "Global Hello!"
void checkHello() {
  System.out.println(hello);         // No such property, exception
  System.out.println(globalHello);   // in scope
}
checkHello();
```

## List and Map

```groovy
// using List
jvmLanguages = ["Java", "Groovy", "Scala", "Clojure"];
println(jvmLanguages[0]);
println(jvmLanguages.size());
jvmLanguages = [];
println(jvmLanguages);

// types can be mixed
jvmLanguages = ["Java", 2, "Scala", new Date()];
```


```groovy
// map = [key:value, key:value];
languageRatings = [Java:100, Groovy:99, Clojure:"N/A"];
println(languageRatings["Java"]);
println(languageRatings.Clojure);
languageRatings["Clojure"] = 75;
println(languageRatings["Clojure"]);
languageRatings = [:]; // empty map
println languageRatings;
```
