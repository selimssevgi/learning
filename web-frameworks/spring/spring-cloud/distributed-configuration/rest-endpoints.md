# REST Endpoints

- {application} maps to 'spring.application.name' on client

- {profile} maps to spring.profiles.active on client

- {label} server side feature to refer to set of config files by name(git branch)

- GET /{application}/{profile}[/{label}]

- GET /myapp/dev/master
- GET /myapp/prod/v2
- GET /myapp/default

- GET /{application}-{profile}.(yml | properties)

- /myapp-dev.yml
- /myapp-prod.properties
- /myapp-default.properties

- GET /{label}/{application}-{profile}.(yml | properties)

- /master/myapp-dev.yml
- /v2/myapp-prod.properties
- /master/myapp-default.properties
