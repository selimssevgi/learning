# JSP notes

### Motivation
Putting all html tags in response writer inside our servlets is a huge pain.


- '<% %>' between those two tags is executed as Java code.

```jsp
<%
  int i = 3;
  int j = 2;
  int k = i + j;
  out.println("k is " + k);
%>
```

- Output is used so often.

```jsp
<%
  int i = 3;
  int j = 2;
  int k = i + j;
%>

k is <%=k%>
```

- Method declaration tag. It will be available in all other tags.

```jsp
<%!
public int add(int a, int b) {
  return a + b;  
}
%>
```

- Import tag.

```jsp
<%@ page import="java.util.Date" %>
```

- JSP code is converted to servlet by Tomcat. All code except method declaration
  goes into service() method in the servlet.

- MVC: model:Bean, View: JSP, Controller: Servlet
