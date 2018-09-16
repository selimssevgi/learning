# Application AutoScaler

- Monitors the application metrics and acts on it.

- Can define rules based on cpu load or time of the day.

```shell
cf m
cf marketplace -s app-autoscaler
cf create-service app-autoscaler gold autoscaler
cf bind appname autoscaler
```
