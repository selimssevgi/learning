# Encryption and Decryption

- Encrypted configuration at rest and/or in-flight

- at rest: it is encrypted on disk
- in-flight: encrypted as it travels between the config server and config client

- /encrypt and /decrypt, by default they are not secured

- Works with symmetric or asymmetric keys


```shell
# application.properties
my.datasource.username=foobar
my.datasource.password={cipher}SOMERANDOMCHARACTERs

# use single quotes in yml around curly braces
```

* At what point is configuration decrypted?

1. upon request at the server (default) - use it if connection between is secure

2. Locally at the client on response
   - spring.cloud.config.server.encrypt.enabled=false (on server)


** You must have the Java Cryptography Extension(JCE) Unlimited Strength for Java 8 installed.


### Step One: Choose your key type

- Symmetric key: easier to use, less secure

- Asymmetric key:

### Step Two(Symmetric): Configure the config server

```shell
# application.properties
encrypt.key=<secret-key>
```

### Step Two(Asymmetric): Configure the config server

- option 1

```shell
# application.properties
encrypt.key=<pem-encoded-key-as-text>
```

- option 2

```shell
# application.properties
encrypt.keyStore.location=<path-to-location>
encrypt.keyStore.password=<keystore-pass>
encrypt.keyStore.alias=<key-name-in-keystore>
```
