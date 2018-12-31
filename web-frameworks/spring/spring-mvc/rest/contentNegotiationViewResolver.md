# ContentNegotiatingViewResolver

- is a special view resolver that takes the content type that client wants into consideration

- determine the requested media type(s)
- find the best view for the requested media type(s)

- 'Accept' header is not so reliable (usually is text/html)

- ContentNegotiatingViewResolver considers the Accept header and uses whatever
  media types it asks for, but only after it first looks at the URL's file extension

- if there is no Accept header and the extension is no help, it falls back / as
  the default content type, the client has to take whatever representation server sends

- Unlike Spring's other view resolvers, ContentNegotiatingViewResolver does not
  resolve views on its own. it delegates to other view resolvers

- gets candidate views, and requestedMediaTypes and returns the first match

### ContentNegotiationManager

- we can change the default strategy for the media-type selection process

- a few things we could do with ContentNegotiationManager:

* specify a default content type to fall back

* specify a content type via a request parameter

* ignore the request's Accept header

* map request extensions to specific media types

#### configuration

1. directly declare a bean whose type is ContentNegotiationManager(too involved)
2. Create the bean indirectly via ContentNegotiationManagerFactoryBean(better for xml)
3. Override the WebMvcConfigurerAdapter#configureContentNegotiation (better for java)

```java
@Override
public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
  configurer.defaultContentType(MediaType.APPLICATION_JSON);
}

@Bean
public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
  ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
  cnvr.setContentNegotiationManager(cmn);
  return cnvr;
}

@Bean
public ViewResolver beanNameViewResolver() {
  return new BeanNameViewResolver();
}

@Bean
public View spittles() {
  return new MappingJackson2JsonView();
}
```

- if the logical view name is "spittles", then the configured
  BeanNameViewResolver resolves the View declared in the spittles(). That is
  because the bean name matches the logical view name

## Limitation

- the key benefit of using ContentNegotiatingViewResolver is that it layers REST
  resource representation on top of Spring MVC with no change in controller code

- the same controller can serve HTML for human, JSON or XML for non-human client

- Content negotiation is a convenient option when there is a great deal of
  overlap between your human and non-human interfaces

- ContentNegotiatingViewResolver has a serious limitation:
  - as a ViewResolver, it only has an opportunity to determine how a resource is rendered to a client
  - it has no say in what representations a controller can consume from the client
  - if the client is sending JSON/XML, then it is not much help

- another thing with using ContentNegotiatingViewResolver is that the View
  chosen renders the model --not the resource-- to the client

- expection

```json
[
  {
    "id": 42,
    "message": "Hello World!",
    "time": 1400389200000
  },
  {
    "id": 43,
    "message": "Blast off!",
    "time": 1400475600000
  }
]
```

- because the model is a map of key-value pairs, the response looks more like this

```json
{
  "spittleList": [
    {
      "id": 42,
      "message": "Hello World!",
      "time": 1400389200000
    },
    {
      "id": 43,
      "message": "Blast off!",
      "time": 1400475600000
    }
  ]
}
```

* see Spring's message converters
