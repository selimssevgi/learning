# A bean's life

1. instantiate

2. populate properties

3. BeanNameAware's setBeanName()

4. BeanFactoryAware's setBeanFactory()

5. ApplicationContextAware's setApplicationContext()

6. pre-initialization BeanPostProcessors

7. initializingBean's afterPropertiesSet()

8. call custom init-method

9. post-initialization BeanPostProcessors

10. bean is ready to use

11. container is shutdown

12. DisposableBean's destroy()

13. call custom destroy method
