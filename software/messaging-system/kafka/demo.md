# Simplest Kafka Demo

- quickstart guide

```shell
# start zookeeper
zookeeper-server-start.sh config/zookeeper.properties

# test zookeeper
telnet localhost 2181
# type 'stat'


# start single kafka broker
./bin/kafka-server-start.sh config/server.properties

# zookeeper component is responsible for assigning a broker to be responsible for the topic
./bin/kafka-topics.sh --create --topic my-topic --zookeeper localhost:2181 --replication-factor 1 --partitions 1

# created files in /tmp/kafka-logs/my-topic-0


## query the topics
./bin/kafka-topics.sh --list --zookeeper localhost:2181
```

## Producer

```shell
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic my-topic
# keeping writing and pressing enter
```

## Consumer

```shell
bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic my-topic --from-beginning
```
