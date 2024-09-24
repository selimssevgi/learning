# Install vscode

- install the tar

```shell
tar -xvf code.tar.gz
sudo mv vscode /usr/local/vscode
echo "export VSCODE='/usr/local/vscode'" >> ~/.bash_profile
echo "export PATH=$PATH:$VSCODE/bin" >> ~/.bash_profile
```
