# Webpack

- Takes all of assets and outputs them to a production-ready bundle

- Bundles JS files into one file, minimizing http requests
- Process SASS / LESS files into CSS and only use them where needed
- Convert JSX or ES2015 into vanilla JS which browsers understand


## Install


```shell
npm install webpack -g
```

```shell
npm init
npm install webpack --save-dev
```

### Usual

- when there is not so much javascript

```javascript
// script-1.js
let message = "hello world!";
alert(message);
```

```html
<script src="script-1.js"></script>
```

### Sometimes

- when there is so much javascript around

- require doesnt work by itself

```javascript
// script-1.js
let message = require('./script-2.js');
alert(message);
```

```javascript
// script-2.js
module.exports = "hello world!";
```

- so many http requests

```html
<script src="script-1.js"></script>
<script src="script-2.js"></script>
```

### Webpack to rescue


```shell
webpack script-1.js bundle.js
```

```html
<script src="bundle.js"></script>
```

### webpack.config.js

- just run 'webpack'
- src='dist/bundle.js'

```javascript
var path = require('path');

module.exports = {

  // define entry point: require'ing other js files
  entry: './src/script-1.js',

  // define output point
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'dist')
  }

};
```

## Loaders

- Perform transformations
- Babel loaders transform ES2015 or JSX in vanilla JS

### Using Babel Loader


```shell
npm install babel-core babel-loader babel-preset-es2015 --save-dev
```
