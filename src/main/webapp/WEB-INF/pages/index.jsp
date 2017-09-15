<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	
	$invProcessRqstForm = $('#routeOptimizerForm');
	$invProcessRqstForm.ajaxForm({  success: loadCreateInvProcRqst });
	
	function loadCreateInvProcRqst(responseText, statusText) {
		$('#routeOptimizerDiv').html($.trim(responseText));
		$(window).scrollTop(0);
	}
	function addinputFields(){
	    var locationCount = document.getElementById("locationCount").value;
	}
}); 
</script>
</head>
<body>
	Number of location:
	<input type="number" name="locationCount" id="locationCount" >
	<br />
	<button id="btn" onclick="addinputFields()">Add</button>
	<div id="routeOptimizerDiv">
		<form id="routeOptimizerForm" action="distance.do"
			name="routeOptimizerForm">
			<c:forEach items="${locationList}" var="location" begin="1"
				end="5" varStatus="counter">
				<table>
					<tr>
						<td><label for="Latitude"> Latitude</label></td>
						<td><input id="latitude" name="latitude${counter.index }"
							type="text" value="${location.latitude}" /></td>
					</tr>
					<tr>
						<td><label for="Longitude">Source Longitude</label></td>
						<td><input id="longitude" name="longitude" type="text"
							value="${location.longitude}" /></td>
					</tr>
				</table>
				<hr />
			</c:forEach>
			<button id="search" name="search">Find me a distance</button><br/>
		</form>
	</div>
</body>

</html>