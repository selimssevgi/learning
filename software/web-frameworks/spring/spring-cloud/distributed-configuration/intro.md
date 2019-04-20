# Distributed Configuration

- What's so different about managing configuration in a cloud-native app?

- Configuration management tooling? Chef/Puppet/Ansible ?

## Issues with typical configuration management

- It could work, but not ideal for the cloud

- They are deployment-oriented

- In case of a change, need to redeploy the application

- So costly, for debugging a simple change

- push-based is usually not dynamic enough, can miss a newly started instance

- pull-based adds latency with temporal polling.

* Then what solves the problem?

## Application Configuration Server

- Dedicated, dynamic, centralized key/value store (may be distributed)

- Authoritative source

- Auditing

- Versioning

- Cryptography support

## Options

- Spring cloud provides ways to manage config with:

* Spring Cloud Consul
* Spring Cloud Zookeeper

- Consule and Zookeeper are not built for configuration server, both are
  commonly utilized for other purposes like service discovery.

* Spring Cloud Config
