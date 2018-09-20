# kubectl

```shell
kubectl version --client
```

- kubectl can be configured to talk to any Kubernetes

```shell
kubectl config current-context

kubectl get nodes

kubectl create -f pod.yml

kubectl get pods
kubectl describe pods
kubectl describe pods/hello-pod
kubectl describe pods --all-namespaces
kubectl get pods hello-pod
```
