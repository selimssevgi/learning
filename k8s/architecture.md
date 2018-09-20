# K8s Architecture

- An orchestrator for microservice apps

- K8s is like a like couch for a team of containers

- It organizes things so that they work together on the right networks woth the
  right sequence, all of that hocus-pocus, we end up with a useful app made up
  of lots of moving parts

- The master is the cluster control plane, monitors clusters, make changes,
  schedules work, responds to events.

- Nodes/Minions, they run the actual work. they report back to the masters and
  they watch for changes

### Declarative model and desired state

- manifest file(yaml or json) to describe 'desired state'

- manifest files are effectively a record of intent

- manifest files constitute what we call the desired state of the cluster
