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
            <h2>Careers at Expertus</h2>
		</div>
		<div>
			<form:form id="CareersForm" modelAttribute="job" action="signInProcess" method="post">
				<table>
		        	<tr>
		        		<td>Username :</td>
		        		<td>${username}</td>
		            </tr>
		            <tr>
		            	<td>Full Name :</td>
		        		<td>${firstname}, ${lastname}</td>
		            </tr>
		            <tr>
		            	<td>Profil :</td>
		        		<td>${profil}</td>
		            </tr>
	        	</table>
	        	<div>
				<form method="POST" action="upload" enctype="multipart/form-data" >
		            File:
		            <input type="file" name="file" id="file" /> <br/>
		            Destination:
		            <input type="text" value="/tmp" name="destination"/>
		            </br>
		            <input type="submit" value="Upload" name="upload" id="upload" />
        		</form>
        		<div>
             		<form:button align="center" id="apply" name="apply">Apply</form:button>
				</div>
			</form:form>
		</div>
		<div>
        	<a href="home.jsp">Home</a>
		</div>
    </body>
</html>