# Remote Procedure Calls

- A client posts messages directly onto a queue

- For each posted messages, the client waits for a reply from a reply queue

- This makes this flow *synchronous* process

- When a msg is posted to the server from the client, a *correlation id* is
  generated and attached to the message properties

- The same *correlation id* is put onto the properties in a reply message


```shell

                     /--> Que(rpc_queue, correlation_id = 12) ->\
                    /                                            \
Web API Client  --                                                -- Consumer
                    \                                            /
                     \<-- Que(reply_queue, correlation_id=12))<-/
```
