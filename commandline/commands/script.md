# script

- records a shell session (commands and outputs)

- use cases could be:
  - documentation
  - proof
  - troubleshooting (record hard to reproduce bug)

- real-time recording
  - same script command
  - real-time playback

```shell
script
# script started, file is typescipt # default file name
# do your stuff
exit # or C^D
```

```shell
script myscript.log # override default file name
# do your stuff
exit
```

```shell
script myscript.log --timing=time.log
# do your stuff
exit

scriptreplay -s myscript.log -t time.log
# it will replay the recorded actions
```

- log the output of some command in a bash script

```shell
script -c 'netstat -tupln' netstat.log
cat netstat.log
```
