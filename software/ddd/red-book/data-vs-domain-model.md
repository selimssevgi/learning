# Data Model vs Domain Model

- data-centric approacy using accessors

```java
public class BacklogItem extends Entity {
  private SprintId sprintId;
  private BacklogItemStatusType status;

  public void setSprintId(SprintId sprintId) {
    this.sprintId = sprintId;
  }

  public void setStatus(BacklogItemStatusType status) {
    this.status = status;
  }
}

// client
backlogItem.setSprintId(sprintId);
backlogItem.setStatus(BacklogItemStatusType.COMMITED);
```

- domain model exposes behavior instead of exposing data attributes


```java
public class BacklogItem extends Entity {
  private SprintId sprintId;
  private BacklogItemStatusType status;

  public void commitTo(Sprint sprint) {
    if (!this.isScheduledForRelease())  {
      throw new IAE("Must be scheduled for release to commit to sprint.")
    }

    if (this.isCommittedToSprint()) {
      if (!sprint.springId().equals(this.sprintId())) {
        this.uncommitFromSprint();  
      }
    }

    this.elevateStatusWith(BacklogItemStatusType.COMMITTED);

    this.setSprintId(sprint.sprintId());

    DomainEventPushlisher
      .instance()
      .publish(new BacklogItemCommited(
        this.tenant(),
        this.backlogItemId(),
        this.sprintId()
      ));
  }
}

// client
backlogItem.commitTo(sprint);
```
