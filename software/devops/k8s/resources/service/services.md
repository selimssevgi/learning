# Services

- Pods come and go, every time getting new IPs

- We just can't rely on pod IPs

- For example, we would not want our persistent store to get new IPs every time

- Put a service in the middle with static ip and dns, it will load balance the pods behind itself

- The job of a service: a higher level stable abstraction points for multiple
pods, and they provide loan balancing.

- A pod belongs to a service via labels.

- Labels connect pods and service together and versioning.
- Can add versioning labels in and out easily load balancing among them

**NOTE:** We create our pods, how do we access them? From inside the cluster, or
from outside of cluster. Services is the answer.

- Service gives you reliable IP, DNS, Port.

- Services gives us a stable networking endpoint for our pods, and they load
  balance across the pods as well.

## Creating service in iterative way

```shell
kubectl expose rc hello-rc --name=hello-svc --target-port=8080 --type=nodePort
```

## Create service in declarative way
