# Pivotal Cloud Foundary

- Builts upon cloud foundary

- Bring cloud foundary to enterprise

- Self serve platform for developers

- cf push

- service marketplace

- microservice ready

- IaaS Independent, no locked in to cloud provider. works on aws, openstack, etc

## Elastic Runtime Architecture

### Diego

- Schedules tasks and Long-Running Processes(LRPs)

- Task: Is guaranteed to run at most once, e.g. stage an application

- LRP: typically represented as a web app. Can have multiple instances

- Container: An application instance is run within an immutable container.

- Cell: Containers are run in cell.

- Garden: Containers are managed by Garden

## Cloud Native

- 'Distributed Systems': are hard to build, test, manage, and scale.

- 'Ephemeral Infrastucture': virtual machines and containers are temporary

- 'Immutable Infrastructure': updates to systems and applications are not done
  in-place but rather new, updated instances are created instead.

- 12 Factors

- Processes: execute the app as one or more stateless process
- Concurrency: scale out via the process model.
- Disposability: maximize robustness with fast startup and graceful shutdown.
- Logs: treat logs as event streams.

- config: store config in the os environment variables
- backing services: treat backing services as attached resources


## Managed Servies

- Managed services advertise a catalog of plans from which service instances can be provisioned.

- Managing service instance lifecycle:
  - creating
  - binding
  - unbinding
  - deleting
