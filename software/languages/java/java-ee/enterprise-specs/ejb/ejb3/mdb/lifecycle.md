# lifecycle

* container is responsible for the following:

1. create mdb instances

2. injects resources, including the mdb

3. places instances in a managed pool(if pooling is supported)

4. pulls an idle bean out of the pool when a msg arrives

5. executes the message listener method

6. when onMessage finishes executing, it pushes the idle bean back into pool

7. as needed, retires (and destroys) beans out of the pool
