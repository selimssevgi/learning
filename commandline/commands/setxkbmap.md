# setxkbmap

- Keyboard configuration tool
- use to map capslock to something more useful


```shell
man setxkbmap
cat /usr/share/X11/xkb/rules/base.lst | grep caps:

# caps:ctrl_modifier   Make Caps Lock an additional Ctrl
```

## Map CapsLock to CTRL


```shell
setxkbmap -option caps:ctrl_modifier
```

* make thing change permenant(on ubuntu):
  - search "start" on dash: Start Application
  - add a new one

## CAPS LOCK STUCK

-  https://askubuntu.com/questions/80254/how-do-i-turn-off-caps-lock-the-lock-not-the-key-by-command-line

```shell
python -c 'from ctypes import *; X11 = cdll.LoadLibrary("libX11.so.6"); display = X11.XOpenDisplay(None); X11.XkbLockModifiers(display, c_uint(0x0100), c_uint(2), c_uint(0)); X11.XCloseDisplay(display)'
```
