# Static Transpiling with Babel CLI

```bash
npm init
npm install --save-dev babel-cli
sudo npm instal -g babel-cli
```

- to use transpiled javascript

```html
<script src="bundle.js"></script>
```

- install presets defined in babelrc

```shell
babel ./src/index.js --out-file ./dist/bundle.js
```
