# BlockingQueue

- Simplest extension to java.util.Queue

* Two additional properties:

1. When trying to put() to the queue, it will cause the putting thread to wait
   for space to become available if the queue is full.

2. When trying to take() from the queue, it will cause the taking thread to
   block if the queue is empty.

* Implementations:

1. LinkedBlockingQueue
2. ArrayBlockingQueue


!! TransferQueue
