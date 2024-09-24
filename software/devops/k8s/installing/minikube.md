# Minikube

- Best way of spinning up a local k8s environment

## Architecture

- Localkube(master, node)
- Container runtime(docker, rkt)

- outside kubectl so we can control installation inside VM


## Install

- First install kubectl

```shell
curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
chmod +x minikube
sudo mv -v minikube /usr/local/bin

minikube start
kubectl config current-context # should say minikube

# start with a specific k8s version
minikube start --kubernetes-version="v.1.6.0"


minikube dashboard
```

## Destroy

```shell
minikube stop
minikube delete
```
