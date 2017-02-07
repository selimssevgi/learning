# Jenkins Intallation


```shell
$ wget -q -O - http://pkg.jenkins-ci.org/debian-stable/jenkins-ci.org.key | sudo apt-key add -
$ sudo sh -c 'echo deb http://pkg.jenkins-ci.org/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'

$ sudo apt-get update
$ sudo apt-get install jenkins

# If port 8080 is busy, change it to 8081 in /etc/default/jenkins.
$ sudo service jenkins restart

$ sudo service jenkins status

// 27Jan17: Jenkins doesnt start with Java 9
// use java 8
// admin
// sa
```

## Unlock Jenkins

- localhost:8080
- sudo cat /var/lib/jenkins/secrets/initialAdminPassword

## Configuration

- Manage Jenkins -> Global Tool Configuration
- Add local installation directories
