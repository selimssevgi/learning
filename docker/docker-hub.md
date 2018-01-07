# Docker Hub

- Is a registery and index with a website run by Docker Inc.

- It is the default registry and index used by Docker

- When you issue 'docker pull/run' without specifying an alternative registry,
  Docker will default to looking for the repository on Docker Hub.

* There are two ways that an image author can publish their images on Docker Hub:

1. Use the command line to push images that they built independently and on
   their own systes. Images pushed this way are considered by some to  be less
   trustworthy because it's not clear how exactly they were built.

2. Make a 'Dockerfile' publicly available and use Docker Hub's continuous build system
