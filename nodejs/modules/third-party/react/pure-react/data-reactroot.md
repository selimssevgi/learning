# data-reactroot

- will always appear as an attribute of the root element of your React component

- Prior to version 15, React IDs were added to each node that was a part of your
  component. This helped with rendering and keeping track of which elements
  needed to be updated

- Now, there is only an attribute added to the root, and rendering is kept track
  of based on the hierarchy of elements
