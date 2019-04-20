# Managed Volume Life Cycle

- Managed volumes have life cycles that are independent of any container

## Volume Ownership

- Managed volumes are second-class entities

- No way to share or delete a specific managed volume because you have no way to
  identify a managed volume

- They are only identifiable by the containers that use them

- Removing volumes requires a referencing container, and that makes it important
  to understand which containers own each managed volume

## Cleaning up volumes

- Cleaning up managed volumes is a manual task

- This default functionality prevents accidential destruction of potentially valuable data

- Data can't delete bind mount volumes because the source exists outside the Docker scope

- Docker can delete managed volumes when deleting containers

- docker rm -v option will attempt to delete any managed volumes referenced by
  the target container. Any managed volumes that are referenced by other
  containers will be skipped, but the internal counters will be decremented.(GC?)

- If you delete every container that references a managed volume but fail to use
  the -v flag, you will make that volume an orphan

- Removing orphaned volumes requires messy manual steps

- It is a better idea to avoid the situation by getting into the habit of using the -v option

- You may not even be aware of the volumes created for new containers (metadata)

- Consider using a volume container pattern(using a container as a volume)
