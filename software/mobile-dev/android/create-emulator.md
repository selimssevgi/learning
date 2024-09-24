# Android Emulator

- Open Android Studio -> Try to run an app

- No device connected, create a new emulator (download image)

- ./emulator gives error:

```shell
“PANIC: Missing emulator engine program for 'x86' CPUS.”
```

```shell
export ANDROID_HOME=$HOME/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/emulator
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/tools/bin
export PATH=$PATH:$ANDROID_HOME/platform-tools

alias androidemulator='emulator -avd <name-of-the-avd>'
```
