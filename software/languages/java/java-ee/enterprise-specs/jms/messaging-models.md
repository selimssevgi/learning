# messaging models

- a pattern defining how senders and consumers exchange messages

- jms uses two standard models:
  - point-to-point (PTP)
  - publish-subscribe

### ptp (producer - queue - consumer)

- a single message travel from a single producer (point A) to a single consumer (point B)

- there may be multiple producers and consumers, but only one consumer will process a given message

- ptp message destinations are called *queues*

- ptp doesnt guarantee that messages are delivered in any particular order
  - the term *queue* is more symbolic than anything else

- message-in-a-bottle analogy
  - message in a bottle is set afloat by a lonely castaway(producer)
  - the ocean (queue) carries the message to an anonymous beach dweller(consumer)
  - the message can be *found* only once

## pub-sub (pub - topic - sub)

- analogy: traditional home-delivered newspaper service

- the destination in this model is called *a topic*

### the request-reply model

- you might want a receipt confirmation from shipping company once they have the
  shipping request from the queue

- give the message receiver enough information so that they can *call you back*

- this is known as an overlay model cus it's typically implemented on top of
  either ptp or pub-sub

- ptp: a reply-to queue
- a unique id used by both sides (correlation id)
