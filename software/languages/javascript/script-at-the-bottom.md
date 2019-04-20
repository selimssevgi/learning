# Script at the Bottom of the Page

- For performance reasons, 'script' elements should always be placed at the
  bottom of the document body

1. The first reason is to allow progressive rendering

2. The second is to have greater download parallelization

- The motivation behind the first is that rendering is blocked for all content
  below a 'script' element.

- The reason behind the second is that the browser won't start any other
  downloads, even on a different hostname, if a 'script' element is being downloaded
