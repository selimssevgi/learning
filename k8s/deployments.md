# Deployment

- We do not work pods directly.

- For some time, there was a higher abstraction called 'the replication controller'

- Deployments are all about declarativeness

- Self-documented
- Versioned
- Spec-once deploy-many
- Simple rolling updates and rollbacks

## Theory

- Deployments are all about rolling updates and seamless rollbacks

- Replication Controller wraps around pods (scalability, reliability, desired state)

- Deployment wraps RC(Replicate Set) (updates and rollbacks)
