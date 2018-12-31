# BeanFactory vs ApplicationContext

- there is no single Spring container

- Spring comes with several container implementations that can be categorized
  into two distinct types:

1. org.springframework.beans.factory.BeanFactory

2. org.springframework.context.ApplicationContext

- ApplicationContext builds on the notion of a bean factory by providing
  application-framework services, such as: resolve textual messages from a
  properties file, publish application events to event listeners

- BeanFactoies are often too low-level for most applications. Therefore,
  application contexts are preferred over bean factories
