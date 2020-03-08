# container

- a web container: allows to run web-based apps using servlet, jsp, jsf

- apache tomcat doesnt support ejb3, because unlike application servers, Servlet
  containers aren't required to support ejb

- undertow
- wildfly
- glassfish
c

- tomcat
- jetty

## jee container - application servers

- application server solution that supports ejb3, a web container, other jee apis and services

- oracle weblogic server
- glassfish
- ibm websphere application server
- jboss application server

## embeddable containers

- can be started through a programmatic java api inside your own application

- openejb, easybeans, and embedded jboss are examples

- embeddable containers are only required to support ejb lite

