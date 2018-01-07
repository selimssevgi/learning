# Docker Terminology

## Images

- Software is distributed using images

- Docker creates containers from images

- An image is a file, it holds the files that will be available to containers
  created from it and metadata about the image.

- This metadata contains information about relationships between images, the
  command history for an image, exposed ports, volume definitions, and more

## Repository

- Repositories hold images, is a named buckeet of images

- the name of the host | the user account owning the image | a short name
- quay.io/dockerinaction/ch3_hello_registry

## Tag

- Repositories and tags are used to identify images

- Just as there can be several version of software, each images in a repository
  is identified uniquely with tags

- Whereas a tag can only be applied to a single image in a repository, a single
  image can have several tags

- Until an image is tagged, the only way to refer to it is to use its unique
  identifier that was generated when the image was built
