# Environment-agnostic Systems

- Docker has three specific features to help build environment-agnostic systems:

1. Read-only file systems
2. Environment variable injection
3. Volumes

## Read-only file systems

- Using read-only file systems accomplishes two positive things:

1. You can have confidence that the container won't be specialized from changes
   to the files it contains.

2. You have increased confidence that an attacker can't compromise files in the container

```shell
#! it didnot start check again
docker run -d --name wp --read-only wordpress:4 # wont start without db

docker run -d --name wpdb -e MYSQL_ROOT_PASSWORD=root mysql:5

docker run -d --name wp2 --link wpdb:mysql -p 80 --ready-only wordpress:4
```

- When WP will be read-only we can spin up one more WP container

## Environment variable injection

- Environment variables are key-value pairs that are made availabe to programs
  through their execution context

```shell
docker run --env MY_ENV_VAR="this is a test" busybox env
```

- Using env variable injection this way will help you separate the physical ties
  between a WP container and a MySQL container.

```shell
docker create \
  --env WORDPRESS_DB_HOST="my-db-hostname" \
  --env WORDPRESS_DB_USER="admin" \
  --env WORDPRESS_DB_PASSWORD="password" \
  wordpress:4

docker create -link wpdb:mysql \
 -e WORDPRESS_DB_NAME=client_a_wp wordpress:4

docker create -link wpdb:mysql \
 -e WORDPRESS_DB_NAME=client_b_wp wordpress:4
```
