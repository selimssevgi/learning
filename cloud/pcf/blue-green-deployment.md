# Blue-Green Deployment

- Zero downtime when upgrading can be accomplish with blue-green deployments.


```shell
# Before
myapp.cfapps.io -> app.1.0
myapp-temp.cfapps.io -> app.1.1

# during, both goes same route to see new one works also fine
myapp.cfapps.io -> app.1.0
myapp.cfapps.io -> app.1.1

# After
myapp.cfapps.io -> app.1.1
```

## Serializing Objects

- if using serializing objects, don't make descructive changes
- do not remove fields, do have a serialVersionUID
