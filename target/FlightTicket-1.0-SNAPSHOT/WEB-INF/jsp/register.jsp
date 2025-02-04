<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register New User</title>
</head>
<body style="font-family:Consolas, 'Courier New', monospace; background-image: url('https://cdn-proxy.slickplan.com/wp-content/uploads/2017/11/Registration_Form_Feature.jpg'); background-size: cover;" align="center">
<h1 style="border-style:groove; border-color:black; font-size: 35px" align="center">Register New User</h1>
<form:form modelAttribute="user">

    <table>
        <tr>
            <td>Email:</td>
            <td><form:input path="email" size="30" type="email" required="required"/> <font color="red"><form:errors path="email"/></font></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><form:password path="pass" size="30" required="required"/> <font color="red"><form:errors path="pass"/></font></td>
        </tr>

        <tr>
            <td>Name:</td>
            <td><form:input path="name" size="30" required="required"/> <font color="red"><form:errors path="name"/></font></td>
        </tr>

        <tr>
            <td>Gender</td>
            <td><form:input path="gender" size="30" required="required"/> <font color="red"><form:errors path="gender"/></font></td>
        </tr>

        <tr>
            <td>Contact</td>
            <td><form:input path="contactNo" type="number" pattern=".{10}" size="30" required="required" /> <font color="red"><form:errors path="contactNo"/></font></td>
        </tr>

        <tr>
            <td>Age:</td>
            <td><form:input path="age" size="30" required="required"/> <font color="red"><form:errors path="age"/></font></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Register" /></td>
        </tr>

        <tr>
            <td colspan="2"><br><a href="index.htm" style="font-size: 25px; text-decoration: none">Home Page</a></td>
        </tr>
    </table>
    <br>
</form:form>
<br>
</body>
</html>
