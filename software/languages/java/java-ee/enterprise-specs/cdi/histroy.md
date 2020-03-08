# history of CDI

- dependency injection has been around for a long time

- commercial and open source products

- spring, seam, guice...

- successful but not standardized

- unifies the JSF(@ManagedBean-deprecated) and EJB(@EJB) bean models

- CDI 1.0 in 2009 (JEE6)
- CDI 1.1 in 2013 (JEE7)
- CDI 1.2 in 2013
- CDI 2.0 (JEE8)

### implementations

- weld (reference implementaiton)
- open WebBeans
- CanDI

### cdi packages

package | description
----------------------
javax.inject             | core dependency injection api
javax.enterprise.inject  | core cdi api
javax.enterprise.context | scopes and contextual APIs
javax.enterprise.event   | events and observers apis
javax.interceptor        | interceptor apis
javax.decorator          | decorator apis
javax.enterprise.util    | cdi utility package
