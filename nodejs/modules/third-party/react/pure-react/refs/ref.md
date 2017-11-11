# Refs

- Refs are a feature that allow React components to interact with child elements

- The most common use case for refs is to interact with UI elements that collect
  input from the user

- A ref is an identifier that React uses to reference DOM elements

```javascript
import React from 'react';

export default class AddColorForm extends React.Component {

  constructor(props) {
    super(props);
    this.submit = this.submit.bind(this);
  }

  submit(e) {
    const { _title, _color } = this.refs;
    e.preventDefault();
    alert(`New Color: ${_title.value} ${_color.value}`);
    _title.value = '';
    _color.value = '#000000';
    _title.focus();
  }

  render() {
    return (
      <form onSubmit={this.submit}>
        <input ref="_title"
               type="text"
               placeholder="color title..." required/>
        <input ref="_color"
               type="color" required/>
        <button>ADD</button>
      </form>
    )
  }

}
```
