# Message Queueing

- Provides asynchronous communications protocol

### Examples

-------------------------------------------------
Commercial               | Open Source
IBM WebSphere MQ         | Apache ActiveMQ
Oracle Advanced Queueing | RabbitMQ
SonicMQ                  | ZeroMQ
SwiftMQ                  |

### Properties of MQing

- *Durability:* kept in memory, written to disk, even committed to a database
- *Security Policies:* Which appplication should access to messages
- *Purging Policies:* messages may have a time-to-live, auto-delete
- *Message Filtering:* so subscriber may only see messages matching pre-specified criteria
- *Delivery Policies:* message delivered at least once or no more than once
- *Routing Policies:* which server should receive msgs or a queue's msgs
- *Batching Policies:* msg should be delivered immediately or a bit later many msgs at once
- *Queuing Criteria:* when a msg should be unqueued
- *Receipt Notification:* when a publisher may need to know when some or all subs have received a msg
