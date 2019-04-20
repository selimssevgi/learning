# the life of a request

- a request's job description is that of a courier

- from the time it leaves the browser until it returns with a response, it makes
  several stops, each time dropping off a bit of information and picking up some more

1. Requst -> DispatcherServlet
2. DispatcherServlet -> HandlerMapping
3. DispatcherServlet -> Controller
4. Controller --model and logical view name--> DispatcherServlet
5. DispatcherServlet -> View
6. View -> Response

- Like most Java-based web frameworks, Spring MVC funnels requests through a
  single front controller servet: DispatcherServlet


- DispatcherServlet consults one or more handler mappings to figure out where
  the request's next stop will be.
