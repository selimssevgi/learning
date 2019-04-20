# BeanFactoryPostProcessor

** Can modify the definition of any bean in the factory before any objects are created

- After all bean definitions are loaded

- BeanFactory will check for BeanFactoryPostProcessor, and instantiate those

- Useful for applying transformations to groups of bean definitions

- Several useful implementations are provided by the framework


## By Framework

- PropertyResourceConfigurer - value="${dbUrl}"

## Write your own

- implement the BeanFactoryPostProcessor

