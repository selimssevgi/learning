# RabbitMQ Docker Image

```shell
# starts on default port 5672
docker run -d --hostname my-rabbit --name some-rabbit rabbitmq:3
docker logs some-rabbit
```


## With Management Enabled

- web ui on localhost:15672
- default username/password guest/guest

```shell
docker run -d --hostname rmq-m -p 15672:15672 -p 5672:5672 --name rmq-m rabbitmq:3
```

## rabbitmqctl

```shell
docker container exec rmq-m rabbitmqctl list_exchanges
```
