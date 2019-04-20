# Container State and Dependencies

- Docker container will always be in one of four states


```shell

                  +----------------+                  +----------------+
    --run-->      |                |    --pause-->    |                |
                  |   RUNNING      |                  |   PAUSED       |
                  |                |    <--unpause--  |                |
                  +----------------+  <               +----------------+
                        ^  |           \
               restart  |  | kill        \
               start    |  | stop          \ restart
                        |  v                 \
                  +----------------+           \      +----------------+
    --create-->   |                |             \    |                |
   <--remove--    |   EXITED       |                  |   RESTARTING   |
                  |                |    <--stop--     |                |
                  +----------------+                  +----------------+
```
