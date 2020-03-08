# as DI container

- every bean managed by the container is automatically registered with jndi

- a typical container jndi registry will also store jdbc data sources, jms
  queues, jms connection factories, jpa entity managers, jpa em factories,
  javamail session, and so on

- jndi root
  - jdbc
    - oracleDS
    - petStoreDB
  - jms
    - QConFactory
    - DemoQueue
  - app-1
    - ejb-1
    - ejb-2
    - entitymanager


- resources are stored in jndi tree in a hierarchical manner
- this means that hndi resource names look very much like computer FS
