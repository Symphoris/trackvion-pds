//test
jQuery(document).ready(function($) {
  $(".notify").css("display","none").delay(1000).fadeIn(2000).delay(2000).fadeOut(2000);
  $(".notify").hover(function() {
      $(this).stop(true, true).fadeIn();
  }, function() {
      $(this).stop(true, true).delay(1000).fadeIn(2000).delay(500).fadeOut(800);
  });
});
