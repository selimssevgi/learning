# streams can be cold or hot

### cold streams

- are lazy
- they dont do anything until someone starts observing them
- they only start running when they are consumed
- cold streams are used to represent asynch actions
  - it won't be executed until someone is interested in result
- file download
- the data produced by a cold stream is not shared among subscribers and when
  you subscribe you get all the items

- Cold Observables produce notifications on demand, and for every Subscriber, they produce independent notifications.

- a cold observable is a music CD. Many people can buy it and listen to it independently

### hot streams

- are active before the subscribtion
- like a stock ticker, data sent by a sensor or user
- data is independent of an individual subscriber
- when an observer subscribes to a hot observable, it will get get all values in
  the stream that are emitted AFTER it subscribes
- the values are shared among all subscribers

- a hot observable is a radio station. All of the listeners that are listening
  to it at this moment listen to the same song.
