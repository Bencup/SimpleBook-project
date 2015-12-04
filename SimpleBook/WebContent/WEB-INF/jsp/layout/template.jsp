<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="contextPath" scope="request" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>

<head>
<meta charset="utf-8">
<title><tiles:insertAttribute name="title" /></title>
 <link href="${contextPath}/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="${contextPath}/js/jquery-2.0.3.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script> 

<link href="${contextPath}/css/material-fullpalette.css" rel="stylesheet" />
<link href="${contextPath}/css/material-fullpalette.min.css" rel="stylesheet" />
<link href="${contextPath}/css/material.css" rel="stylesheet" />
<link href="${contextPath}/css/material.min.css" rel="stylesheet" />
<link href="${contextPath}/css/ripples.css" rel="stylesheet" />
<link href="${contextPath}/css/ripples.min.css"rel="stylesheet" />
<link href="${contextPath}/css/roboto.css" rel="stylesheet" />
<link href="${contextPath}/css/roboto.min.css" rel="stylesheet" />

<link href="${contextPath}/js/data-table-responsive/css/dataTables.responsive.css" rel="stylesheet" />
<link href="${contextPath}/js/advanced-datatable/css/demo_table.css" rel="stylesheet" /> 

<link href="${contextPath}/css/custom.css" rel="stylesheet" />
	
	<script type="text/javascript"
	src="${contextPath}/js/material.js"></script>
	<script type="text/javascript"
	src="${contextPath}/js/material.min.js"></script>
	<script type="text/javascript"
	src="${contextPath}/js/ripples.js"></script>
	<script type="text/javascript"
	src="${contextPath}/js/ripples.min.js"></script>
	<script type="text/javascript"
	src="${contextPath}/js/data_table/js/jquery.dataTables.custom.js"></script>
	<script type="text/javascript"
	src="${contextPath}/js/data-table-responsive/js/dataTables.responsive.min.js"></script>
	<script type="text/javascript"
	src="${contextPath}/js/data-tables/DT_bootstrap.js"></script>
	<script type="text/javascript">
		var contextPath = '${contextPath}';</script>
	
</head>

<body>
	
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
	
	<script type="text/javascript">
	$(document).ready(function() {
		$.material.init();	
	});
	
	</script>
</body>
</html>