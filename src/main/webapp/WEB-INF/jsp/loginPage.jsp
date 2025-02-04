<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Login Page</title>
</head>
<body style="font-family: Consolas, 'Courier New', monospace; display: flex; flex-direction: column; align-items: center;">
<h1 style="border-style: groove; border-color: black; font-size: 35px" align="center">User Login</h1>
<div style="display: flex; justify-content: center;">
        
        <form:form modelAttribute="user" style="font-size: 25px; text-decoration: none">
            <table>
                <tr>
                    <td>User Email:</td>
                    <td><form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font></td>
                </tr>

                <tr>
                    <td>Password:</td>
                    <td><form:password path="pass" size="30" /> <font color="red"><form:errors path="pass"/></font></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="Login" /></td>
                </tr>
            </table>
            <br>
        </form:form>
       </div>
    <div style="display: flex; justify-content: center; margin-top: 20px;">
        <img src="https://learningforlife.pixel-online.org/common/img/login.jpg" alt="Login" />
    </div>
    <br>
    <a href="index.htm" style="font-size: 25px; text-decoration: none">Home Page</a>
</body>
</html>
