# history of ejb

- java didnot have standard capabilities for back-end services at the time
  - persistence, transaction integratiy, concurrency

- ibm released ejb spec in 1997

- sun adopted in 1999 as ejb 1.0

- before ejb 3.0 had to implement interfaces


- ejb 3.2 is now subset of javaee 9 spec
- ejb 1.0 - all java based, cumbersome
- ejb 2.0 - java based + xml; tedious
- ejb 2.1 - java based + xml; sligtly easier
- ejb 3.0 - java based + xml + annotations; easier
- ejb 3.1 - java based + xml + annotations; easierer

# ejb 3.x

### strengths

- simplified programming model
- simplified deployment model
- more robust persistence structure

### weaknesses

- yet another new programming model
- AOP and DI not as robust as other frameworks
- limited vendor support

### new features in ejb3.0

- annotation instead of deployment descriptors
- callback methods and listeners
- interceptors
- DI


### new features in ejb3.1

- simplified ejb development -- no interfaces
- singleton session beans
- enhanced timer service
- application profiles
- @LocalBean
- all ejbs are managed beans


#### finding ejb references

- traditionally, ejb containers defined their own "naming" scheme
  - varied by app server vendor
  - path and entry name could be overridden in xml deployment descriptor

- in ejb3.1, there are global jndi naming conventions:
  - qualified class name
  - java:global[/<app-name>]/<module-name>/<bean-name>
  - java:app[/<module-name>]/<bean-name>
  - java:module/<bean-name>

### new features in ejb3.2

- ejb 2 has been made optional by ejb3.2
- mdb
  - jms2.0
  - cdi
  - MessageListener is optional
- disable passivation(need to implement Serializable to be passivated)
  - @Stateful(passivationCapable=false)


```java
// prior ejb3.2
public interface A{}
public interface B{}

@Stateless
@Local({A.class, B.class})
public class ServiceBean implements A, B{}

// ejb3.2
@Stateless // by default local interface
public class ServiceBean implements A, B{}
```
