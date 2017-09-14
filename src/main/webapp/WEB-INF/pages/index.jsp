<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<script type="text/javascript">

$(document).ready(function () {
    $('#search').click(function () {
        jQuery.support.cors = true;
      
         var sourcelatitude = document.getElementById('sourcelat').value;
         var sourceLongitude = document.getElementById('sourcelon').value;
         var source ={"latitude":sourcelatitude,"longitude":sourceLongitude}
         var destinationlatitude = document.getElementById('destinationlat').value;
         var destinationLongitude = document.getElementById('destinationlon').value;
         var destination ={"latitude":destinationlatitude,"longitude":destinationLongitude}

        $.ajax(
            {
                type: "POST",
                url:'distance',
                data: {'source':source,'destination':destination},
                contentType: "application/json; charset=utf-8",
                mimeType: 'application/json',
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

</script>  
</head>
<body>

		<form
        id = "form"
        action = "#"
        name = "form">
			Source Latitude<input id="sourcelat" type="text" /><br/>
			Source Longitude<input id="sourcelon" type="text" /><br/>
			 Destination Latitude<input id="destinationlat" type="text" />  <br/>
			 Destination Longitude<input id="destinationlon" type="text" /><br/>
			<button id="search" name="search">Find me a distance</button><br/>
		</form>
	
</body>

</html>