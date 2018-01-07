# Dockerfile

- A script that describes steps for Docker to take to build a new image

* There are two disadvantages to taking this approach:

1. Depending on the specifics of the project, the build process might take some time
2. Dependencis may drift between the time when the Dockerfile was authored and
   when an image is built on a user's computer
