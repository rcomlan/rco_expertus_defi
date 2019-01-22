<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sign In</title>
		<spring:url value="/resources/css/stylesheets.css" var="stylesheetcss" />
		<spring:url value="/resources/js/home.js" var="homeJs" />
		<spring:url value="/resources/js/jquery-1.12.4.js" var="jqueryJs" />
		
		<link href="${stylesheetcss}" rel="stylesheet" />
		<script src="${homeJs}"></script>
    	<script src="${jqueryJs}"></script>
	</head>
	<body>
		<div class="form">
			<img src="${pageContext.request.contextPath}/images/logo.jpg" alt="Logo Expertus" class="logo-signin">
		</div>
		
		<div class="form">
			<form:form id="signinForm" modelAttribute="login" action="signInProcess" method="post">
                <table>
                    <tr>
                        <td>
                            <form:label path="username">Username: </form:label>
                        </td>
                        <td>
                            <form:input path="username" name="username" id="username" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password:</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                      
                    </tr>
                    <tr>
                        
                    </tr>
                    <tr>
                        <td>
                        	<form:button id="login" name="login">Login</form:button>
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
            
            <table>
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
                    
        </body>
</html>