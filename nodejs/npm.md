# npm - Node Package Manager

- https://www.npmjs.com/


```shell
npm -v

npm help

npm install -h

npm init

npm init --yes # all defualts, default can be set
npm init -y

npm install                          # download the dependency in package.json

npm i express
npm install express                  # installing locally in current project
npm install express -g               # installing globally
npm install express --save           # add also as a dependency in package.json
npm install express --save-dev       # add it as a dev-dependency
npm install express@4     --save     # latest major version
npm install express@4.2   --save     # latest patched version
npm install express@4.2.0 --save     # exact version

npm uninstall express
npm uninstall express -g
npm uninstall express --save
npm uninstall express --save-dev

// uninstall : remove : rm : un

npm list                       # see all installed packages and dependencies
npm list --depth 1             # limit the depth of dependencies
npm list --depth 0             # just installed packages
npm list --global true --depth 0

npm prune                      # remove unused extra packages
```
