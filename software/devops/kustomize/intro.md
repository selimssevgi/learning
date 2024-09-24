# intro to kustomize

- declarative app management tool for k8s
- comes with kubectl or as a standalone

### problem

- we have configuration files for k8s
- this configuration files might have different values for different env
- how can we solve this problem?


### kustomize

- it is native to k8s
- a template-free way to customize k8s objects
- has concept of bases and overlays

- overlays directories contain env-specific changes


