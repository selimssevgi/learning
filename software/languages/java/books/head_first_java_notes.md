# Head First Servlets and JSP - 2004

## Chapter 1 - Intro and Overview

- The amount of data you can send along with the GET is limited, and it's
  exposed up here in the browser bar for everyone to see(password?). Better to
  use POST request in such cases. Another difference between POST and GET is
  that GET url can be bookmarked such as searching.

- Two things the web server alone won't do:
  - dynamically-created pages
  - the ability to write/save data on the server

- Web server(Apache Web Server) application serves only static pages. Therefore,
  it needs a helper app to generate html files just-in-time.

## Chapter 2 - Web App Architecture

- Servlets dont have a main() method. They are under the control of another Java
  application called a 'Container'.

- What does the Container give you? 
  - Communication support(Web Server <-> Container)
  - Lifecycle management
  - Multithreading support(a new thread for each request)
  - Declarative security(web.xml)
  - JSP support(Translating jsp to servlet)

- A servlet can have 3 names:
  - Client-know URL name
  - Deployer-known 'secret internal' name
  - Actual 'file' name

- Mapping servlet names improves your app's flexibility(changing internal
  structure) and security(hide internal structure).

- With MVC the business logic is not only separate from the presentation... It
  doesnt even know that there IS a presentation.

- A fully-compliant EE application server must have both a web Container and an
  EJB Container (plus other things a JNDI and JMS implementation). Tomcat is
  just a web Container! It is still compliant with the portions of EE spec that
  address the web Container.

- Application Server (Web Container + EJB Container)

## Chapter 3 - Mini MVC Tutorial

- Model: POJO, Controller: Servlet, View: JSP

- The Container provides a mechanism called "request dispatching" that allows
  one Container-managed component to call another.

```java
request.setAttribute("result", result);
RequestDispatcher view = request.getRequestDispatcher("result.jsp");
view.forward(request, response);
```

## Chapter 4 - Request and Response - Being a Servlet

- Idempotent means you can do the same thing over and over again, with no
  unwanted side effects.

- POST method is not idempotent.

- Idempotent in HTTP/Servlet way to mean that the same request can be made twice
  with no negative consequences on the server.

- addHeader(): adds an additional value. setHeader(): replaces the value.

- response.sendRedirect(String): server gives another URL, so client ask for
  that. Telling client to call someone else. URL on the browser changes. It
  should be called before setting any header or body response.

- request dispatch is asking a co-worker to handle the request. Server does the
  work. URL on the browser doesnot change.

## Chapter 5 - Attributes and Listeners - Being a Web App
## Chapter 6 - Session Management - Conversational State
## Chapter 7 - Being a JSP
## Chapter 8 - Scriptless JSP - Script-free pages
## Chapter 9 - Using JSTL
## Chapter10 - Custom tag development
## Chapter11 - Web application deployment

