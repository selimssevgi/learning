# how routing works

1. url is changed
2. match path
  - process redirect
  - go to step 2
3. process guards
4. resolve data
5. activate component(s)
6. display template(s)


- when you use 'href' with links, the browser will request a new URL from the
  server, which is not what we want

- 'routerLink' allows the angular router to handle the actual navigation
