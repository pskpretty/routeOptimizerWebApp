<html>
<head>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script> -->
<!-- <script type="text/javascript">


$(function () {
    $('form').on('submit', function (e) {
    	var sourcelatitude = document.getElementById('sourcelat').value;
        var sourceLongitude = document.getElementById('sourcelon').value;
        var source ={"latitude":sourcelatitude,"longitude":sourceLongitude}
        var destinationlatitude = document.getElementById('destinationlat').value;
        var destinationLongitude = document.getElementById('destinationlon').value;
        var destination ={"latitude":destinationlatitude,"longitude":destinationLongitude}
        var url='http://localhost:8080/routeOptimizerWebApp/distance';
        alert(JSON.stringify(source));
       $.ajax(
           {
               type:'post',
               url:url,
               data: {source:source,destination:destination},
               contentType: "application/json; charset=utf-8",
               dataType: 'json',
               success: function (response) {
					console.log("success"+response);
                   alert('success'+response);
               return false;
               },
               error: function (msg, url, line) {
                   alert('error trapped in error: function(msg, url, line)');
                   alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);

               }
           });
  });
});
</script>  --> 
</head>
<body>

		<form id ="form" name="form" action="distance.do">
			Source Latitude<input name="sourcelat" id="sourcelat" type="text" /><br/>
			Source Longitude<input name="sourcelon" id="sourcelon" type="text" /><br/>
			 Destination Latitude<input name="destinationlat" id="destinationlat" type="text" />  <br/>
			 Destination Longitude<input name="destinationlon" id="destinationlon" type="text" /><br/>
			 <button  id="search"  name="Search" >Search</button>
		</form>
	
</body>

</html>