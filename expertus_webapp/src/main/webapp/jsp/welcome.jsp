<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome to Expertus</title>
	</head>
	<body>
		<img class="logo-signin" src="logo.jpg" alt="Logo Expertus">
		<div>
			<table>
        	<tr>
        		<td>Username :</td>
        		<td>${username}</td>
            </tr>
            <tr>
            	<td>Full Name :</td>
        		<td>${firstname}, ${lastname}</td>
            </tr>
        </table>
		</div>
		<div>
            <h2>Welcome to Expertus. Enjoy !</h2>
		</div>
		<div>
        	<a href="home.jsp">Home</a>
		</div>
        
        <script src='js/jquery-1.12.4.js'></script>

    <script src="js/home.js"></script>
    </body>
</html>