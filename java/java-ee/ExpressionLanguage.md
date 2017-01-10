# Expression Language Notes

- Motivation: "Use scripting and die".


- Using scripting
```jsp
<% foo.Person p = (foo.Person) request.getAttribute("person"); %>
Person is: <%= p.getName() %>

<%= ((foo.Person) request.getAttribute("person")).getDog().getName() %>
```

- Using EL

```jsp
<jsp:useBean id="person" class="foo.Person" scope="request" />
Person is: <jsp:getProperty name="person" property="name" />

${person.dog.name}
${person["name"]} 
```
- ${person.dog.name} : person can be a Map or a bean.

- ${person["name"]}  : person can be Map, Bean, List or an array.

- ${favoriteFood[0]} and ${favoriteFood["0"]} are same!!!.

- ${musicMap[Genre]} --> ${musicMap["Ambient"]}

- ${musicMap[MusicType[0]]} : nested
