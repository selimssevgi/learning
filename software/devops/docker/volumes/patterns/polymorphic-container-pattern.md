# Polymorphic container pattern

- A polymorphic tool is one that you interact with in a consistent way but might
  have several implementations that do different things

- Using volumes, you can inject different behavior into containers without
  modifying an image

- For example, you may have an image that contains the binaries for node.js and
  by default executes a command that runs the node.js program located at /app/app.js

- You can change the behavior of containers created from this image by
  injecting your own app.js implementation using a volume mounted at /app/app.js


- If you mount a volume where you make additional tools available, you can use
  the docker exec command to run addtional processes in a container:

```shell
docker run --name tools dockerinaction/ch4_tools

docker run -rm \
  --volumes-from tools \
  alpine:latest \
  ls /operations/*

docker run -d --name important_app \
  --volumes-from tools \
  dockerinaction/ch4_ia

docker exec important_app /operations/tools/someTool

docker rm -vf important_app

docker rm -v tools
```
