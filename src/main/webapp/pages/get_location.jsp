<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/reset.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/routeOptimizer.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/routeOptimizer.js"></script>
</head>
<body>
<div id="loading" style="display:none;">
	<div id="loadingContainer" class="ajaxLoader">
		<img id="imgLoading" title="" src="" alt="" />
	</div>
</div>
<div id="ajaxError" style="display:none;">
	<div id="ajaxErrorContainer" class="ajaxLoader">
		<div id="ajaxdiv" class="ajaxdiv">
			Error : <span id="ajaxErrorMessage"></span>
		</div>
	</div>
</div>
<div class="mainContainer">
	<div class="new_Width">
	<div class="dvHeader">
		<div class="irlogoDiv">					
		<h1>
		<a href="#" title="Customer Logo">TEST</a>		
		<span></span></h1>
		</div>
	</div>
	</div>
<div id="homeWrapper" class="menuNavContentWrapper">
<div id="routeOptimizerDiv" class="new_Width">
<div id="locTagDiv">
<div id="routeOptErrContainer" style="display: none;">
	<div class="divError">
	<div class="icon_alert">
	<img src="<%=request.getContextPath()%>/images/icon_alert.png" title="Error" alt="Error" />
	</div>
	<div class="error_msg_long" id="routeOptErrMsg"></div>
	</div>
</div>
<div id="routeOptSucContainer" <c:choose><c:when test="${uploadInvoiceBean.status=='SUCCESS'}">style="display:block;"</c:when><c:otherwise>style="display: none;"</c:otherwise></c:choose>>
	<div class="divSuccess">
	<div class="icon_alert"><img src="<%=request.getContextPath()%>/images/icon_success.png" width="13" height="11" title="Create Invoice Process" alt="Create Invoice Process" class="sucImg" /></div>
	<div class="success_msg">Please refer the optimized route.</div>						
	</div>					
</div>
<fieldset class="frmTwoCol">
<legend class="link1">Add Route Optimizer</legend>
<div class="toggle-item-link1">
<div class="dvRow">
<div class="Col">
  	<label for="noOfLoc">Number of Locations</label>
	<input type="text" name="noOfLoc" id="noOfLoc" value="" />
	<input type="button" name="btnNoOfLoc" id="btnNoOfLoc" value="Add" onclick="addLocation();" class="routeOptBtns"/>
</div>
</div>
</div>
</fieldset>
</div>
	<form id="routeOptimizerForm" action="save.do" name="routeOptimizerForm" method="POST">
	<table id="routeOptimizerTbl" style="display:none;" class="display" width="100%">
	<thead>
	<tr>
	<th>Number</th>
	<th>Latitude</th>
	<th>Longitude</th>
	</tr>
	</thead>
	<tbody id="routeOptimizerTblBody">	
	</tbody>
	</table>
<div class="routeOptButtonBar">
<div class="routeOptBtnLeftSide">&nbsp;</div>
<div class="routeOptBtnRightSide">
<div class="btn">
<input tabindex="11" class="routeOptBtns" type="submit" value="Submit" name="routeOptSubmit" id="routeOptSubmit" onclick="return saveRouteOptimizer();" title="Submit"/>	
<!-- <a tabindex="12" href="javascript:void(0);" id="delete" title="Reset" class="admin_delete" onclick="return deleteLegalEntity();">Reset</a>
 -->
 </div>
</div>
</div>
</form>
</div>
</div>
</div>

</body>

</html>