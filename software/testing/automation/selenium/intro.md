# intro to selenium

- set of tools and libraries that automates web browser actions
- not a tool but a library of tools

1. identify web elements (using identifiers like id, xpath)
2. add actions (using your preferred programming language)
3. run the test

### features

- flexible and extensible
- multiple language supported
- multiple browsers supported

### components

- selenium IDE
  - a record and playback plugin
  - firefox add-on
  - useful for quick prototype testing

- selenium RC (remote control)
  - also known as selenium 1
  - used to execute scripts (written in any language) using JS
  - selenium 1 is deprecated, is not actively supported

- webdriver
  - an api used to send commands directly to the browser
  - is a successor to selenium RC
  - selenium RC and webdriver are merged to form selenium 2

- selenium grid
  - a tool to run tests in parallel across different machines and different browsers simultaneously
  - used to minimize execution time

- selenium 3
  - all selenium RC implementation is replaced with webdriver compatible components

#### releases

           | Core              | WebDriver            |
-----------------------------------------------------
1.0 (2006) | selenium RC       |                      |
2.0 (2011) | selenium RC       | WebDriver            |
3.0 (2016) |                   | WebDriver            |
