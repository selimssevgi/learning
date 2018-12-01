# Inverse Data Flow

- A common solution for collecting data from a React component

- It is similar to, and sometimes described as, two-way data binding

- It involves sending a callback function to the component as a property that
  the component can use to pass data back as arguments


```javascript
import React from 'react';
import PropTypes from 'prop-types';

export default class AddColorForm extends React.Component {

  constructor(props) {
    super(props);
    this.submit = this.submit.bind(this);
  }

  submit(e) {
    const { _title, _color } = this.refs;
    e.preventDefault();
    this.props.onNewColor(_title.value, _color.value);
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

AddColorForm.propTypes = {
  onNewColor: PropTypes.func
};

AddColorForm.defaultProps = {
  onNewColor: f => f
};
```

## Refs in Stateless Functional Components

- Stateless functional components do not have 'this', so it's not possible to
  use 'this.refs'


```javascript
const AddColorForm = ({onNewColor= f => f}) => {
  let _title, _color;
  
  const submit = e => {
    e.preventDefault();
    onNewColor(_title.value, _color.value);
    _title.value = '';
    _color.value = '#000000';
    _title.focus();
  }

  return (
    <input ref={input => _title = input} 
           type="text"
           placeholder="color title..." required/>
    <input ref={input => _color = input}
           type="color" required/>
    <button>Add</button>
  );
}
```
