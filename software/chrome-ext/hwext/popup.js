$(function() {
  $("#name").keyup(function() {
    $("#greeting").text("Hi, " + $("#name").val() + "!");
  });
});
