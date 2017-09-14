<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<script type="text/javascript">
alert("hi");
$(document).ready(function () {
    $('#search').click(function () {
        jQuery.support.cors = true;
         var source = [];
         source[0] = Number($('#sourcelat').val()).toFixed(2);
         source[1] = Number($('#sourcelon').val()).toFixed(2);
	var destiation=[];
	destiation[0] = Number($('#destinationlat').val()).toFixed(2);
	destiation[1] = Number($('#destinationlon').val()).toFixed(2);
        $.ajax(
            {
                type: "GET",
                url:'http://localhost:8080/routing/distance',
                        data: {"sourceArray":JSON.stringify(source),"destinationArray":JSON.stringify(destiation)
                            },
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (response) {
			console.log("success"+response);
                    alert('success'+response);
                
                },
                error: function (msg, url, line) {
                    alert('error trapped in error: function(msg, url, line)');
                    alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);

                }
            });


        alert('button click');

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