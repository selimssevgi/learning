
const link = 'http://www.filltext.com?rows=5&content={string}'

window.onload = function () {

  let xh = new XMLHttpRequest();

  xh.onreadystatechange = () => {
    if (xh.readyState === 4 && xh.status === 200) {
 //     console.log(JSON.parse(xh.response));
    }
  };

  xh.open('GET', link, true); // true for async
  xh.send();

  // jQuery method
  $.get(link, (data) => {
    console.log(data);
  });

};

/*
 * Ready States:
 *
 * 0 - request not initialized
 * 1 - request has been set up
 * 2 - request has been sent
 * 3 - request is in process
 * 4 - request is complete
 * */
