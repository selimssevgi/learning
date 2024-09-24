# Introduction to Volumes

- A container with database. Run it and store data in the db.Where the data is
  stored? In a file in the container? What happens when container is deleted?

- Different container, where they would write their logs?

- A volume is a mount point on the container's directory tree where a portion of
  the host directory there has been mounted.

- Without volumes, container users are limited to working with the union file
  system that provides image mounts

- Although the union file system works for building and sharing images, it's
  less than ideal for working with persistent or shared data

- Volumes fill those use cases and play a critical role in containerized system design

* Volumes provide container-independent data management

- Database software vs database data
- Web application vs log data
- Data processing application vs input and output data
- Web server vs static content
- Products vs support tools

* Volumes enable separation of concerns and create modularity for architectural components

- A 'polymorhpic' tool is one that maintains a consistent interface but might
  have several implementations that do different things.

- Tomcat is an application that provides an HTTP interface on a network

- A database program always presents the same interface but takes on a wholly
  different value depending on the data that can be injected with a volume
