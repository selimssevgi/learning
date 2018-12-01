# Apache Kafka as a Messaging System

- It has pub-sub model

- But they are called Producers and Consumers

- Topics are group of messages.

- Kafta keeps and maintains in Broker

## Broker

- A deamon service

- A synonym for a Broker is also a server

- It has access to resources on the machine, such as file system, which it uses
  to store messages, which it categorizes as topics

- Can run more than one one a machine, but must be configured in a way not to
  have conflict among them

## CLuster

- Grouping of multiple Kafka brokers

- Brokers can be on the same or different machines

- One broker on a machine: Cluster of 1
- Two brokers on a machine: cluster of 2
- Two brokers on two different machines: cluster of 2
- It does not matter if brokers are on the same machine or not

## Distributed Systems

- Collection of resources that are instructed to achieve a specific goal or function

- Consist of multiple workers or nodes

- The system of nodes require coordination to ensure consistency and process
  towards a common goal

- Each node communicates with each other through messages

## Controller Node

- In a group of brokers, one should should be the controller node

- Maintains an inventory of what workers are available to take on work
- Maintains a list of work items that has been committed to and assigned to workers
- Maintains active status of the staff and their progress on assigned tasks
