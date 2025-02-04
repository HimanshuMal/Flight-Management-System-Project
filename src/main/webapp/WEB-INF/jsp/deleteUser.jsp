
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete User Account</title>
    </head>
    <body style="font-family:Consolas, 'Courier New', monospace" align="center">
        <h1 style="border-style:groove; border-color:black; font-size: 35px" align="center">Delete User Account</h1>
        <form:form modelAttribute="user">
            <table>
		<tr>
		    <td>User Email Id:</td>
		    <td><form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font></td>
		</tr>

		<tr>
		    <td colspan="2"><input type="submit" value="Delete" /></td>
		</tr>
            </table>
            <br>
        </form:form>
            <a href="viewAllUsers.htm" style="font-size: 25px; text-decoration: none">View All Users</a><br><br>
            <a href="adminWelcome.htm" style="font-size: 20px; text-decoration: none">Back to admin home page</a></br></br>
    </body>
</html>
