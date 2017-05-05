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

