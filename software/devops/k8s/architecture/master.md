# Master

- Cluster control panel

- Keep the master free of work, let the nodes do the work

### kube-apiserver:

- front-end to the control plane, exposes the REST API

- Tell what you want to do via YAML manifest file

### Clustor Store

- Persistent storage (its memory)

- The config and the state of cluster gets persistently stored in here

- It uses etcd(distributed, consistent, watchable, nosql key-store)

- etcd is the "source of truth" for the cluster

### kube-controller-manager

- Controller of controllers

- Node, endpoints, namespace controller

- Watches for changes

- Helps maintain 'desired' state

### kube-scheduler

- Watches apiserver for new pods

- Assigns work to nodes(affinity/anti-affinity, constraints, resources...)


**NOTE:** No other master components expose an endpoints for us except
apiserver(by default on port 443)

- The master is the brain of the k8s
- The commands and queries come into the apiserver component of the master
