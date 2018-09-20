# Nodes

- a.k.a. "minions"

- The k8s workers

1. Kubelet
2. Container runtime
3. kube-proxy

## Kubelet

- The main Kubernetes agent
- Registers node with cluster
- Watches apiserver
- instantiates pods
- reports back to master
- exposes endpoint on :10255 (lets you inspect the kubelet)
- /spec, /healthz, /pods

- If kubelet cannot carry on its own work, it does not restart or start a new
  node. It reports back to master and master decides what to do

## Container Engine

- does container management
- pulling images
- starting/stopping containers
- for the most part the container runtime is going to be docker
- kubelet talks to the container api

## kube-proxy

- Kubernetes networking
- Pod IP addresses
- All containers in a pod share a single IP
- Load balances across all pods in a service
