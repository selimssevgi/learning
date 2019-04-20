# /etc/passwd

- We we log in to a Unix system, the system looks up our login name in its
  password file, usually the file /etc/passwd

```shell
cat /etc/passwd

mysql:x:119:127:MySQL Server,,,:/nonexistent:/bin/false
statd:x:120:65534::/var/lib/nfs:/bin/false
jenkins:x:121:129:Jenkins,,,:/var/lib/jenkins:/bin/bash
```

- each entry in the file is composed of seven colon-separated field

- loginName:encryptedPassword:userId:groupId:commentField:homeDir:shellProgram

- All contemporary systems have moved the encrypted password to a different file

- The system knows which shell to execute for us based on the final field
