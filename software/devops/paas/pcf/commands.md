# cf commands


- cf app appname # retrieve information and route of the application

- cf env appname # environment variables

- cf restart appname

- cf restage appname # use it in order to pull in new dependencies


- create a manifest file after deploying app using various commands, and modify
- cf create-app-manifest attendee-service -p ./manifest.yml
