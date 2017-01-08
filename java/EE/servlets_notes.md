# Servlet Notes

- Servlet Life Cycle
- Servlet Architecture
- HttpServletRequest and HttpServletResponse
- Filters

- It is inside javax.servlet package.
- Usually it comes inside Tomcat/lib folder.
- Most of time it extends HttpServlet(AC).
- Tomcat logs the sout statements in servlet classes.

## Full Picture
1. Container --reads------> web.xml
2. Container --creates----> ServletContext
3. Container --creates----> context-params
4. Container --transfers--> context-params to ServletContext
5. Conteiner --creates----> ServletContextListener objects
6. Container --calls------> Listener#contextInitialized(sce) method
7. ServletContextEvent = ServletContext + ...
8. Container --creates----> servlet object
9. Container --calls------> init(ServletConfig) method

## Servlet Life Cycle

- Web container 'finds' servlets classes as a first step.
- It either loads them or waits for the first request for a particular servlet.

- init() method of our Servlet.
- service() method of our Servlet.
- destroy() method of our Servlet.
- Garbage collected by JVM.

### init() Method

- The container calls init() on servlet instance after is created but before the
  servlet can service any client. (when)
- Gives you a chance to initialize your servlet before handling any client
  requests.
- It might be overridden to contain like getting a database connection or
  registering yourself with other objects.
- Makes a servlet a servlet. by calling constructor there will be an ordinary
  object, by calling init() method afterwards there will be a servlet.
- Can add Initialization code here
- Per servlet configuration
- Can configure parameters in annotations or web.xml
- Simple init() is for overriding.

### service() Method

- When the first client request comes in, the Container starts a new thread or
  allocates a thread from the pool, and causes the servlet's service() method to be invoked.
- This method looks at the request, determines the HTTP method(GET,POST...) and
  invokes the matching doGET(), doPOST() etc. on the servlet.
- It should NOT be overridden. doGet(), doPOST() should be overridden instead.
- Overridden in HttpServlet
- Decides which doXXX() method should be called
- If doXXX() methods are not overridden in our servlets, an Unsupported
  exception is thrown.

### destroy() Method

- Servlet Container gives chance to servlet to clean up after itself.

## Servlet Architecture
- HTTP request to web server are delegated to to servlet container(Tomcat).
- Tomcat loads the servlet(if already not loaded, created and initialized).
- Tomcat then invokes service() method.
- Tomcat handles multiple requests by spawning multiple threads, each thread
  executing the service() method of a single instance of the servlet.

*Note:* When a request comes Tomcat creates both Request and Response object and
call methods of servlet. Then sends back response to browser.

- Request and Response objects are created per access.
- Servlet object is not created per access.
- Different requests have different servlet threads, not instances.
+------------------------------------------------------------------------------+
|                         +-------------------------------------------------+  |
|                         | Tomcat                                          |  |
|                         |                             +----------------+  |  |
|    +-----------+        |                             |      Web       |  |  |
|    | BROWSER   |        |  Request                    |  Application   |  |  |
|    +-----------+        |  Response                   |   (Servlet)    |  |  |
|                         |                             +----------------+  |  |
|                         |                                                 |  |
|                         |                                                 |  |
|                         +-------------------------------------------------+  |
+------------------------------------------------------------------------------+

## HttpServletRequest and HttpServletResponse

- They are implemented by vendor(Web Container-Tomcat).

### Response Methods

- response.setContentType("text/html");
- PrintWriter out = response.getWriter();            // out.println("Hello");
- ServletOutputStream out = response.getOutputStream(); // out.write(aByteArray)
- response.sendRedirect("success.jsp");
- response.sendRedirect("https://google.com"); // browser does the work

### Request Methods

- request.getParameter("formelementname");
- request.getParameterValues("multiplechoiceformelement"); // checkbox
- request.getRequestDispatcher("success.jsp"); // server does the work
- Cookie[] cookies = request.getCookies();
- HttpSession session = request.getSession();
- String httpMethod = request.getMethod();


## Getting Parameters
- /sayhi?name=Selim : accessing parameter named 'name'.
- In the same way we can access form parameters in doPost method.

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String name = request.getParameter("name");
  PrintWriter writer = response.getWriter();
  writer.println("Hi," + name + "!");
}
```

- request.getParameter("parametername");
- request.getParameterValues("parametername"); return String[]. multiple choice.

## ServletConfig
- ServletConfig's main job is to give you init parameters.
- One ServletConfig object per servlet.
- Things servlet wants to access that you dont want to hard code, like a maybe a
  database name.
- Parameters are configured in the Deployment Descriptor.
- Cannot be accessed in JSP.
- The parameters are defined in specific servlet scope.

## ServletContext
- Works in same way like ServletConfig but in application scope.
- One ServletContext per web app.(The should have named it AppContext.)
- Session works only on one browser, but context is same even the browser changes.
- Across the entire application
- Shared across servlets and users.
- Initialization code / common bulletin board
- In the same way object can be saved by using setAttribute method.
- getServletConfig().getServletContext().getInitParameter()
- this.getServletContext.getInitParameter()

*NOTE:* Think of init parameters as deploy-time constants. You can get them at
runtime, but you can't set them. There's no setInitParameter().

## ServletContextListener
To initialize or create any other object needed application wide. For example
Database connection, getting information from web.xml and create the object
before any servlet start serving.

```java
public class MyServletContextListener implements ServletContextListener{
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext sc = sce.getServletContext();
    String dogBreed = sc.getInitParameter("breed"); // breed context-param
    Dog dog = new Dog(dogBreed);
    sc.setAttribute("dog", dog);
  }

  public void contextDestroyed(ServletContextEvent sce) {
    // destruction

  }
}

```

## Attribute
An attribute is like an object pinned to a bulletin board. Somebody stuck it on
the board so that others can get it.

- ServletContext
- HttpServletRequest
- HttpSession

#### Attributes vs Parameters
- Attributes:
  - Application/Context, Request, Session
  - setAttribute(String name, Object value)
  - Return type: Object
  - getAttribute(String name)

- Parameters:
  - Application/Context init parameters, Request parameters, Servlet init param
  - CanNOT be set. They are defined in web.xml. Request parameters(?query)
  - String
  - getInitParameter(String name)

## Scopes: Context, Request, Session

- Context scope is most accessible and it is not thread-safe!
- One servlet set an attributes and other reads it. Unexpected result.

*NOTE:* Synchronizing servlet doesnt solve thread-safety problems.Instead we will lose
concurrency and be able to just serve one client at a time. And yet other
servlet will access and change context attributes.

```java
synchronized(getServletContext()) {
  getServletContext().setAttribute("foo", "42");
  getServletContext().setAttribute("bar", "22");
}
```

## HttpSession
- Session persists 'across multiple request from the same client'.
- One client can have multiple request from different tabs. This is a reason
  that session in servlets are not thread-safe.
- We can make session thread-safe by synchronizing on HttpSession object.

```java
HttpSession session = request.getSession();
session.setAttribute("savedName", name);

response.getWriter().println("Request parameter has name as " + name);
response.getWriter().println("Session parameter has name as " + session.getAttribute("savedName"));
```

```java
synchronized(session) {
  session.setAttribute("foo", "42");
  session.setAttribute("bar", "22");
}
```

*NOTE:* Only Request attributes and local variables are thread-safe! Everything
else is subject to manipulation by multiple threads, unless you do something to
stop it.

*NOTE:* Look at a well-written servlet, and chances are you won't find any
instance variables. Or at least any that are non-final.

ONE INSTANCE, MANY THREADS.

- HTTP is stateless protocol.
- How to make our servlet remember us?
- Tomcat also provides session object like request and response.
- One HttpSession per user/machine.
- Objects available accross request.
- Every request object has a handle to the session object.
- An HttpSession object can hold conversational state across multiple requests
  from the same client.
- It persists for an entire session with a specific client.
- We can use it to store everthing we get back from the client in all the
  request the client makes during a session.

#### Simple Idea
On the client's first request, the Container generates a unique session ID and
gives back to the client with the response. The client sends back the session ID
with each subsequent request. The Container sees the ID, finds the matching
session, and associates the session with the request.

Server and Client exchange info(session ID) through cookies(in request header).

Container generates unique session ID and cookie object.
```java
HttpSession session = request.getSession();
```
- You dont make the HttpSession object yourself.
- You dont generate the unique session ID.
- You dont make the new Cookie object yourself.
- You dont associate the session ID with the cookie.
- You dont set the Cookie into response.
- All cookie work happens behind the scene.

- whether session already existed or was just created?

```java
HttpSession session = request.getSession();

if (session.isNew()) {
  out.println("This is a new message!");
} else {
  out.println("Welcome back!");
}
```

```java
HttpSession session = request.getSession(false); // just give me if you have it

if (session == null) {
  out.println("no session was available");
  out.println("creating one...");
  session.getSession();
} else {
  out.println("There was a session!");
}
```

*NOTE:* If the client(browser) is disabled to accept cookies, then above method
wont work. Everytime a new session will be created by Container but client will
ignore it.

URL rewriting can be used in case of cookies are disabled. URL + ;jsessionid=123

### Cookies
- You can use cookies to exchange name/value String pairs between the server and
  the client.

- The server sends the cookie to the client, and the client sends it back with
  each subsequent request.

- Session cookies vanish when the client's browser quits, but you CAN tell a
  cookie to persist on the client even after the browser shuts down.


```java
Cookie cookie = new Cookie("username", name);
cookie.setMaxAge(30*60);
response.addCookie(cookie);

Cookie[] cookies = request.getCookies();
for (Cookie cookie: cookies) {
  if (cookie.getName().equals("username")) {
    out.println("Hello " + cookie.getValue());
  }
}

```

*NOTE:* There is one ServletContext per VM. There is one ServletConfig per
servlet, per VM. But there is only one HttpSession object for a given session ID
per web app, regardless of how many VM's the app is distributed across.
## RequestDispatcher
- Has two methods:
  - forward(ServletRequest, ServletResponse)
  - include(ServletRequest, ServletResponse)

- There are two way to access RequestDispatcher object.
  - request.getRequestDispatcher("result.jsp"); // relative path
  - getServletContext().getRequestDispatcher("/result.jsp"); // must start /

## Servlet Inheritance

- GenericServlet (init(), init(ServletConfig), service())
        ^
        |
- HTTPServlet (service())
        ^
        |
- MyServlet (doGet(), doPost())


## Servlet Filters

  - To intercept requests from client before they access a resource at back end.
  - To manipulate responses from server before they are sent back to the client.
  - Example Filters:
    - Authentication Filters
    - Data Compression Filters
    - Logging Filters
    - Encryption Filters

#### ? Annotation vs XML Conf
  In case of XML we just need to change web.xml file and restart Tomcat. However,
  in case of annotation we have recompile  and redeploy the class. Annotations are
  less verbose and are available after Java 1.5V.

  - XML

  ```xml
  <servlet>
    <servlet-name>xmlServlet</servlet-name>
    <servlet-class>org.selimssevgi.XmlServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>xmlServlet</servlet-name>
    <url-pattern>/xmlservletpath</url-pattern>
  </servlet-mapping>
  ```

  - Annotation

  ```java
  @WebServlet(urlPatterns = {"/xmlservletpath"})
  public class XmlServlet extends HttpServlet {}
  ```


## Annotations

### @WebServlet
  It used to annotate a servlet class.

  ```java
  @WebServlet
  public class MyServlet extends HttpServlet {}
  ```

  We can define how the servlet will be accessed.

  ```java
  @WebServlet(urlPatterns = { "/firstServlet" })
  public class MyServlet extends HttpServlet {}
  ```

  Now we can access on localhost:8080/firstServlet. It is case-sensitive.

