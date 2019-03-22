$(document).ready(function() {
	$.ajax({
		url: "http://localhost:8091/info/home"
	}).then(function(data) {
	  var items = [];
	  $.each( data, function( key, val ) {
		items.push("Id: "+val.id +", Name: "+val.name+"<br/>");
	  });
      $('.result').append(items);
	});
	$.ajax({
		url: "http://localhost:8091/info/get"
	}).then(function(data) {
	  var items = [];
	  $.each( data, function( key, val ) {
		items.push("Id: "+val.id +", Name: "+val.name+"<br/>");
	  });
      $('.result').append(items);
	});
});