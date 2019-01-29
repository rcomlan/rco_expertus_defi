<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome to Expertus</title>
		<spring:url value="/resources/css/stylesheets.css" var="stylesheetcss" />
		<spring:url value="/resources/js/home.js" var="homeJs" />
		<spring:url value="/resources/js/jquery-1.12.4.js" var="jqueryJs" />
		<spring:url value="/resources/images/logo.jpg" var="logo" />
		
		<link href="${stylesheetcss}" rel="stylesheet" />
		<script src="${homeJs}"></script>
    	<script src="${jqueryJs}"></script>
    	<link href="${logo}" rel="stylesheet" />
	</head>
	<body>
		<img src="${pageContext.request.contextPath}/images/logo.jpg" alt="Logo Expertus" class="logo-signin">
		<div>
			<form:form id="CareersForm" modelAttribute="jobapplication" action="/careers/{username}/thanks" method="get">        	
	        	<div>
		            <h2>Thanks for your submission</h2>
				</div>
			</form:form>
		</div>
		<div>
        	<a href="${pageContext.request.contextPath}/home.jsp">Home</a>
		</div>
    </body>
</html>