# Kafka Partitions

- Topic is logical, partition is physical

- The implementation of the logical concept of topic

- The topic as a logical concept is represented by one or more physical log files called partitions

- The number of partitions per topic is entirely configurable

- Each partition is maintained on at least one or more brokers

- Partitions are stored on /tmp/kafka-logs/{topic}-{partition}.(index|log)

- Each partition must fit entirely on one machine.
- You cannot split a single partition across multiple machines

* In general, the scalability of Kafka is determined by the number of partitions
  being managed by multiple broker nodes


## Partitioning Trade-offs

- Having multiple partitions is a must in order to effectively scale out o

- The more partitions the greater the Zookeeper overhead

- Message ordering can become complex

- The more partitions the longer the leader fail-over time
