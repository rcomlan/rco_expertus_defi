<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registration</title>
	</head>
<body>
	<div class="form">
		<img class="logo-signin" src="logo.jpg" alt="Logo Expertus">
	</div>
	
	<div class="form">
		<form:form id="signupForm" modelAttribute="user" action="signUpProcess" method="post">
              <table align="center">
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
                      
                  </tr>
                  <tr>
                      
                  </tr>
                  <tr>
                      <td>
                      	  <form:button align="center" id="signup" name="signup">Register</form:button>
                      </td>
                  </tr>
                  
                  <tr>
                      
                  </tr>
                  <tr>
                      
                  </tr>
                  <tr>
                      <td>
                      	  <a href="home.jsp">Home</a>
                      </td>
                  </tr>
              </table>
    	</form:form>
	</div>
            
            <script src='js/jquery-1.12.4.js'></script>

    		<script src="js/home.js"></script>
</body>
</html>