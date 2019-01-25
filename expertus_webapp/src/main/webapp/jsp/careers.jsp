<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<style>
			table, th, td {
			  border: 1px solid black;
			  border-collapse: collapse;
			}
			th, td {
			  padding: 5px;
			}
			th {
			  text-align: left;
			}
			table#t01 {
			  width: 100%;    
			  background-color: #f1f1c1;
			}
			table#t01 thead {
			  background-color: blue;
			  color: white;
			}
			table#t01 td {
			  align: center;
			}
			div {
			  padding: 2px;
			}
			
		</style>

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
		
		<form:form id="CareersForm" modelAttribute="login" action="signInProcess" method="post">
			<div>
				<table>
		        	<tr>
		        		<td>Username :</td>
		        		<td>${username}</td>
		            </tr>
		            <tr>
		            	<td>Full name :</td>
		        		<td>${firstname}, ${lastname}</td>
		            </tr>
		            <tr>
		            	<td>Profil :</td>
		        		<td>${profil}</td>
		            </tr>
	        	</table>
        	</div>
        	        	
       		<div>
		        <table id="t01" style="width:100%">
		            <caption><h3>Available jobs</h3></caption>
		            <thead>
		                <tr class="tr tr-success">
		                    <td>Reference </td>
		                    <td>Published date</td>
		                    <td>End publish date</td>
		                    <td>Job Title</td>
		                    <td>Level</td>
		                    <td>Salary ($CAD/year)</td>
		                    <td>Status</td>
		                    <td>Select</td>
		                </tr>   
		            </thead>
		            <tbody>
		                <c:forEach items="${jobs}" var="jobs">
		                    <tr>
		                        <td>${jobs.refjob}</td>
			                    <td>${jobs.datepublish}</td>
			                    <td>${jobs.endpublishdate}</td>
			                    <td>${jobs.jobtitle}</td>
			                    <td>${jobs.level}</td>
			                    <td>${jobs.salary}</td>
			                    <td>${jobs.status}</td>
			                    <td><input type="checkbox" name="id" value=" "></td>
		                    </tr>
		                </c:forEach>
		            </tbody>
		        </table>
		    </div>
		    <br>
		</form:form>
		
		<div>
			<form method="POST" action="upload" enctype="multipart/form-data" >
				Your resume :
				<input type="file" name="file" id="file" /> <br/>
				<br>
				Destination:
				<input type="text" value="C:\Temp" name="destination"/>
				<br>
				<br>
				Applicable pour toutes les candidatures*
				<input type="submit" value="Upload" name="upload" id="upload" />
			</form>
		</div>
	
		<div>
		
		</div>
		
		<div>
        	<a href="home.jsp">Home</a>
		</div>
    </body>
</html>