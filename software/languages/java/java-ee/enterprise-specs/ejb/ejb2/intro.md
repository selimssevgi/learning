# ejb 2.0

- session and entity beans can expose a 'local client view'
- client interfaces do not extends java.rmi.Remote

- home object and EJBObject are not Remote object, running in the same jvm

- EJBLocalObject, EJBLocalHome


## bean lifecycle

* stateful session beans
  - bean creation (when the client wants a bean)
  - bean use (when client calls a business method)
  - bean passivation (the bean is put to sleep to conserve resources)
  - bean activation (bean wakes up to service a business method from the client)
  - bean removal(when the client is finished with the bean, or bean times out)

* stateLESS session beans
  - bean creation (when the client wants a bean)
  - bean use (when client calls a business method)
  - bean removal(when the client is finished with the bean, or bean times out)

