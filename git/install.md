# Install

- git-scm.com

```shell
apt-get install git

which git

git --version
```

## Configuration

- System  level config: /etc/gitconfig
- User    level config: ~/.gitconfig
- Project level config: {project}/.git/config

```shell
git config --system
git config --global  # user
git config           # project
```

```shell
git config --global user.name "username"
git config --global user.email "some@gmail.com"

git config --list
# user.name = username

git config user.name

git config --global core.editor "vim"
git config --global color.ui true

git config --global alias.st "status"
```

## Git auto-completion

- https://github.com/git/git/tree/master/contrib/completion

```shell
cd ~
curl -OL {above_link}/git-completion.{(ba|z)sh}
mv ~/git-completion.bash ~/.git-completion.bash # hidden
```

```shell
# .bash_profile
if [ -f ~/.git-completion.bash ]; then
  source ~/.git-completion.bash
fi
```

## Help

```shell
man git
git help
git help log
```
