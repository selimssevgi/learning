# JSP notes
A JSP becomes a servlet. A servlet that you don't create. Container looks at
your JSP, translates it into Java source code, and compiles it into a
full-fledged Java servlet class.

- JSP code is converted to servlet by Tomcat. All code except method declaration
  goes into service() method in the servlet.
- '<% %>' between those two tags is executed as Java code.

### Motivation
Putting all html tags in response writer inside our servlets is a huge pain.

* Directive   :  <%@ %>
* Scriptlet   :  <%  %>
* Expression  :  <%= %>
* Declaration :  <%! %>
* EL          :  email = ${applicationScope.mail}
* Action      :  <jsp:include file="foo.html />

### Directives
A directive is a way for you to give special instructions to the Container at
page translation time.

- page
- include
- taglib

*NOTE:* You donot put semicolon at the end of a directive.

#### page Directive
- To import a single package:
```jsp
<%@ page import="java.util.Date" %>
```

- To import multiple packages:
```jsp
<%@ page import="foo.*;java.util.Date" %>
```

### Scriptlet
Scriptlets are just plain old java that lands as-is within the generated
servlets' service method.

```jsp
<%
  int i = 3;
  int j = 2;
  int k = i + j;
  out.println("k is " + k);
%>
```
### Expression
- Part of the whole point of JSP to avoid println()!
- Container takes everything between <%= %> and puts it in as the argument to
  out.println().


```jsp
<%= Counter.getCount() %>

# turns into
out.print(Counter.getCount());
```

```jsp
<%
  int i = 3;
  int j = 2;
  int k = i + j;
%>

k is <%=k%>
```

### Declaration
Are for declaring members of the generated servlet class.That means both
variables and methods.

Anything between <%! and %> is added to the class outside the service method.

- Instance/Class Variables
```jsp
<%! int count = 0; %>
```
- Method
```jsp
<%!
public int add(int a, int b) {
  return a + b;  
}
%>
```

### Implicit Objects
- There are definid inside jspService() method.
- Local variables that can be used in JSP code.

API                 | Implicit Object
--------------------------------------
          JspWriter | out
 HttpServletRequest | request
HttpServletResponse | response
        HttpSession | session
     ServletContext | application
      ServletConfig | config
       JspException | exception
        PageContext | pageContext
             Object | page

### JSP LifeCycle
1. Write and deploy JSP file.
2. Container reads the web.xml doesnt do anything with jsp file
3. JSP sitting there until the first request hits it
4. Container translate and generate java code from jsp after first request
5. Container compiles java file (errors caught here)
6. Container laods .class file
7. Container instantiates the servlet and calls jspInit()
8. The object is now a full-fledged servlet
9. Contaienr creates a new thread and call \_jspService() method.

### Configuring JSP Servlet init parameters

```xml
<web-app>
  <servlet>
    <servlet-name>MyTestInit</servlet-name>
    <jsp-file>/TestInit.jsp</jsp-file>
    <init-param>
      <param-name>email</param-name>
      <param-value>email@email.com</param-value>
    </init-param>
  </servlet>
</web-app>
```

### Overriding init (jspInit) Method

```jsp
<%!
  public void jspInit() {
    ServletConfig config = getServletConfig();
    String email = config.getInitParameter("email");
    ServletContext ctx = getServletContext();
    cxt.setAttribute("email", email);
  }
%>
```

*NOTE:* Just know JSP to understand and maintain other JSP code, not to write JSP!!!

*NOTE:* Expression Language is used for calling Java code defined somewhere else
in JSP/HTML.

## Expression Language
EL came into picture:
- Not to have Java code in JSP(is same worse html in java and java in html)
- Making things eaiser for web designers to get involved without knowing java
- JSP without java in it, is easir to maintain

* Disabling scriptlets 

```xml
<web-app>
  <jsp-config>
    <jsp-property-group>
      <url-pattern>*.jsp </url-pattern>
      <!-- Disabling script elemens in JSP -->
      <scripting-invalid>true</scripting-invalid>
      <!-- Ignoring EL, by default is enabled -->
      <el-ignored>true</el-ignored>
    </jsp-property-group>
  </jsp-config>
</web-app>
```

```jsp
<%-- following line is not in JSP specs anymore --%>
<%@ page isScriptingEnabled="false" %>
```

```jsp
<%-- has priority than xml --%>
<%@ page isELIgnored="true" %>
```
