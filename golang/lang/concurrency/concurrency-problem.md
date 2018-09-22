# The Concurrency Problem

- Husband, Wife, Eggs(shared data)

- Husband looks into fridge, see that there are not so many eggs
- Decides to go shopping for more
- Later on wife comes, and looks for eggs, and decides to shop for them as well
- At the end, there will be extra eggs. Problem?

- Maybe put lock on the eggs?
- Locks, semaphores, mutexes?

## Real World Solution

- Husband says that he is responsible of the eggs
- When the number of eggs is low, he will take care of it
- If he knows the wife is in shopping, he will call and ask her to do it

- Now husband is in full control of the data
- They are not sharing the data

- Sharing data is too messy
- Communicate data so the data is not going to be the thing that we share
- Instead of data, we are going to share a communication channel

- Threads are going to use the channel to communicate instead of data

**Do not communicate by sharing memory; instead, share memory by communicating**
