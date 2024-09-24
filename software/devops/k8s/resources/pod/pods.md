# Pods

- in VMware world, the atomic unit of deployment is the virtual machine
- in Docker world, it is the container
- in the kubernetes world, it is the pod

- K8s run containers, but always inside pods

- Pods can have multiple containers(advanced use-case)

- Cannot run a container just by itself in k8s, even it is a single container,
  it has to run inside a pod

- The pod itself does not actually run anything, just a sandbox

- All containers in pod share the pod environment

- If you have tight coupled container using same volume or memory, put them in the same pod

- Unit of scaling in k8s is also pod.
- Do not add more instance of the container in the same pod for scaling, run
  them in different pods.

- Multi-container pods: e.g: web server(main container) + log scraper(sidecar container)

- Pods are atomic
- You do not see them in getting ready phases, is not there, and there already
- You cannot have a single pod spread over multiple nodes.

- Replication controller is replaced by 'Deployment'

## Working with pods

- A pod has a single IP
- Pods hold all the namespaces, and any container they run just joining and
  sharing those namespaces.

- Inter-pod communication: pod network:
- Intra-pod communication: localhost

## Lifecycycle

- Defined deployment in yaml file
- Send it to apiServer
- Pending state: waiting until pod is fully up -> failed
- Running state -> failed
- Succeeded
