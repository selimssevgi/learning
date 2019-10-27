# ejb3

- each ejb is implemented by
  - business interface
  - implementation

- each ejb is described by meta-data
  - tell container how to manage ejb
  - annotation-based in java

- key description elements
  - ejb name (class name)
  - ejb JNDI name (fully qualified class name)
  - ejb type (implemented interface)
  - security and trx information


* can mark interface with @Local, and implementations with:
  - @Stateful
  - @Stateless
  - @Singleton

* @LocalBean is an ejb 3.1 feature
  - used when dont have a business interface, just the class
  - tell the container it is a local bean

### accessing ejb

- client finds a proxy to interact with an ejb using:
  - JNDI (for remote clients or legacy ejbs)
  - DI - @EJB (for local clients or application clients)
