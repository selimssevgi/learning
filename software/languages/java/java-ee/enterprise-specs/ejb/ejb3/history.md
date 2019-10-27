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

#### finding ejb references

- traditionally, ejb containers defined their own "naming" scheme
  - varied by app server vendor
  - path and entry name could be overridden in xml deployment descriptor

- in ejb3.1, there are global jndi naming conventions:
  - qualified class name
  - java:global[/<app-name>]/<module-name>/<bean-name>
  - java:app[/<module-name>]/<bean-name>
  - java:module/<bean-name>
