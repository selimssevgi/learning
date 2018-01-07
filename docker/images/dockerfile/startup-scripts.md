# Startup Scripts



### Environmental preconditions validations

- If container configuration problems always cause failures at startup time for
  an image, users can be confident that a started container will keep running

- Script is generally use-case specific

- The script should validate as much of the assumed context as possible

* Presumed links (and aliases)
* Environment variables
* Network access
* Network port availability
* Root file system mount parameters (read-write or read-only)
* Volumes
* Current user

- Any language can be used to writing the script, but better to use something
  already included with the image. /bin/sh or /bin/bash

```shell
#!/bin/bash
set -e

if [ -n "$WEB_PORT_80_TCP" ]; then
  if [ -z $"WEB_HOST" ]; then
    WEB_HOST='web'
  else
    echo >&2 '[WARN]: Linked container, "web" overridden by $WEB_HOST.'
    echo >&2 "===> Connecting to WEB_HOST ($WEB_HOST)"
  fi
fi

if [ -z "$WEB_HOST" ]; then
  echo >&2 '[ERROR]: specify a linked container, "web" or WEB_HOST env variable'
  exit 1
fi

exec "$@" # run the default command
```
