# Jenkins Plugins

- Jenkins needs to perform a restart after new plugin install


### Before Installing a Plugin

- Manage Jenkins -> Prepare Shutdown(at the bottom)
- Halt any jobs that are due to be executed so plugins can be installed safely
- Afterwards Jenkins can be restarted(localhost:8080/restart)

### Installing Plugins

- There is an option to 'install without restart'?
- Manage Jenkins -> Manage Plugins
- Available tab, filter by 'plugin-name' // checkstyle, findbugs
