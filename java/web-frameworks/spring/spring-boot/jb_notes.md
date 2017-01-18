## What is Spring?
- Application framework
- Programming and configuration model
- Infrastructure support(databases etc.)

## Problems with Spring
- Huge framework
- Multiple setup steps
- Multiple configuration steps
- Multiple build and deploy steps

- *Can we abstract these steps?*

## What is Spring Boot?

- SB makes it easy to create stand-alone, production-grade Spring based
  Applications that you can "just run".

- Spring Boot is a framework designed to make Spring development easier
- Reduces the complexity of working with Spring through automatic configuration
- Unlocks projects under the Spring portfolio
- Eliminates barriers to entry

## Boot Principles
- Reduce the amount of work for Spring developers
- Opinionated - reasonable defaults that are easily customized
- Convention over configuration
- Dependency management without names and versions
- No code generation or XML
- Stand alone(embedded container)
  - Convenience
  - Servlet container config is now application config
  - Useful for microservices architecture
- Production ready

## Technical Approach
- Automatic configuration
- Starter POMs and dependencies
- Executable jars
- Embedded containers
- Build tool integration


## Ways to Booting Spring Boot
- STS IDE(Idea -> Spring Initialzr)
- Spring Initializr(start.spring.io -> import into IDE)
- Spring Boot CLI(Groovy)

## Customizing Spring Boot(application.properties)
- resources/application.properties
- "Spring Common application properties" for full list


## Steps

1. Create a maven project
2. Add parent maven project for spring boot

```xml
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>1.4.3.RELEASE</version>
</parent>

<!-- spring web project dependency -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

3. Create a class with main method

- Sets up default configuration
- Start Spring application context
- Performs class path scan
- Starts Tomcat server

```java
@SpringBootApplication
public class CourseApiApp {
  public static void main(String[] args) {
    SpringApplication.run(CourseApiApp.class, args);
  }
}
```

4. Add a controller

- A java class(ClassNameController)(@Controller)
- Marked with annotations(@RestController)
- Has info about
  - What URL access triggers it?(@RequestMapping("/hello"))
  - What method to run when accessed?


```java
@RestController
public class TopicController {

  @Autowired
  private TopicService topicService;

  @RequestMapping("/topics")
  public List<Topic> getAllTopics() {
    // automatically converted to json because it is RestController!
    return topicService.getAllTopics();
  }

  @RequestMapping("/topics/{id}")
  public Topic getTopic(@PathVariable String id) {
    return topicService.getTopic(id);
  }

  @RequestMapping(value = "/topics", method = RequestMethod.POST)
  public void addTopic(@RequestBody Topic topic) {
    topicService.addTopic(topic);
  }

  @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
  public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
    topicService.updateTopic(id, topic);
  }

  @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
  public void deleteTopic(@PathVariable String id) {
    topicService.deleteTopic(id);
  }
}
```

### Rest Course API

- Topics

GET      /topics      Gets all topics
GET      /topics/id   Gets the topic
POST     /topics      Create new topic
PUT      /topics/id   Updates the topic
DELETE   /topics/id   Deletes the topic

## Add a Service

- It is a singleton
- Create a java class: NameService (@Service)
- Add it to controller as a fied (@AutoWired): Spring will inject the instance
  at startup


```java
@RestController
public class TopicController {

  @Autowired
  private TopicService topicService;

  @RequestMapping("/topics")
  public List<Topic> getAllTopics() {
    // automatically converted to json because it is RestController!
    return topicService.getAllTopics();
  }

  @RequestMapping("/topics/{id}")
  public Topic getTopic(@PathVariable String id) {
    return topicService.getTopic(id);
  }

  @RequestMapping(value = "/topics", method = RequestMethod.POST)
  public void addTopic(@RequestBody Topic topic) {
    topicService.addTopic(topic);
  }

  @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
  public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
    topicService.updateTopic(id, topic);
  }

  @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
  public void deleteTopic(@PathVariable String id) {
    topicService.deleteTopic(id);
  }
}
```
