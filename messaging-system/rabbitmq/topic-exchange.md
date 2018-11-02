# Topic Based Pub/Sub

- Messages sent on topic exchange don't just have an arbitrary routing key

- Routing key must be a list of words separated by dots.

```shell
payment.card
payment.purtchaseorder
payment.*
```

- A star can be substituted for exactly one word
- A hash can be substituted for zero or more words

```shell
               |--------- Message Broker -----------------------|

                                /--------> Queue(payment.card)    --> Consumer
                               /
Web Api -----> Topic Exchange / ---------> Queue(payment.porder)  --> Consumer
                              \
                               \
                                \--------> Queue(payment.*)       --> Consumer
```

- Consumer 3 is interested in any message that starts with 'payment'
