# Default Props

- the default values will be used if other values are not provided

- add 'getDefaultProps'

```javascript
Summary extends React.Component {
  static getDefaultProps() {
    return {
      title: "[defaultTitle]",
      steps: 0
    }
  }
}
```

*NOTE:* getDefaultProps is only used on classic React.createClass definitions.
Use a static property named `defaultProps` instead.

```javascript
Summary extends React.Component {
  static defaultProps = {
      title: "[defaultTitle]",
      steps: 0
  }
}
```
