<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<form:form method="post" action="save.do" modelAttribute="locationList">
		<table>
			<tr>
				<th>No.</th>
				<th>Latitude</th>
				<th>Longitude</th>
			</tr>
			<c:forEach items="${locationList.addresses}" var="address"
				varStatus="status">
				<tr>
					<td align="center">${status.count}</td>
					<td><input name="addresses[${status.index}].latitude"
						value="${address.latitude}" /></td>
					<td><input name="addresses[${status.index}].longitude"
						value="${address.longitude}" /></td>
				</tr>
			</c:forEach>
		</table>
		<button id="search" name="search">Distance</button>
		<br />
	</form:form>
</body>
</html>