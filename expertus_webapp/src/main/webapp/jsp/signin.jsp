<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sign In</title>
	</head>
	<body>
		<div class="form">
			<img class="logo-signin" src="logo.jpg" alt="Logo Expertus">
		</div>
		
		<div class="form">
			<form:form id="signinForm" modelAttribute="login" action="signInProcess" method="post">
                <table align="center">
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
            
            <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
            <script src='js/jquery-1.12.4.js'></script>

    		<script src="js/home.js"></script>
            
        </body>
</html>