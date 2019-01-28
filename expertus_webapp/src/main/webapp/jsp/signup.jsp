<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registration</title>
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
	<div class="form">
		<img src="${pageContext.request.contextPath}/images/logo.jpg" alt="Logo Expertus" class="logo-signin">
	</div>
	
	<div class="form">
		<form:form id="signupForm" modelAttribute="user" action="register" method="post" enctype="multipart/form-data">
              <div>
           		<table>
                  <tr>
                      <td>
                          <form:label path="username">Username</form:label>
                      </td>
                      <td>
                          <form:input path="username" name="username" id="username" />
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <form:label path="password">Password</form:label>
                      </td>
                      <td>
                          <form:password path="password" name="password" id="password" />
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <form:label path="firstname">FirstName</form:label>
                      </td>
                      <td>
                          <form:input path="firstname" name="firstname" id="firstname" />
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <form:label path="lastname">LastName</form:label>
                      </td>
                      <td>
                          <form:input path="lastname" name="lastname" id="lastname" />
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <form:label path="email">Email</form:label>
                      </td>
                      <td>
                          <form:input path="email" name="email" id="email" />
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <form:label path="address">Address</form:label>
                      </td>
                      <td>
                          <form:input path="address" name="address" id="address" />
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <form:label path="phone">Phone</form:label>
                      </td>
                      <td>
                          <form:input path="phone" name="phone" id="phone" />
                      </td>
                  </tr>
                  
                  <tr>
                  	<td>
                  		Your resume 
                  	</td>
                  	<td>
                  		<input type="file" name="resume" id="file" /> <br/>
                  	</td>
                  	<td>
                  		<strong>Apply to all jobs submissions *</strong>
                  	</td>
                  	
                  </tr>
                  
           		</table>
              </div>
              <div>
              		<input type="submit" value="Register" name="signup" id="signup" />
			  </div>
		        
        	  <div>
       			<a href="home.jsp">Home</a>
        	  </div>
    	</form:form>
	</div>
</body>
</html>