<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User Data</title>
    </head>
    <body style="font-family:Consolas, 'Courier New', monospace" align="left">
        <h1 style="border-style:groove; border-color:black; font-size: 35px" align="center">Edit User Data</h1>
        <form:form modelAttribute="user">

            <table>
                <tr>
                    <td>Enter current email id (email id cant be updated):</td>
                    <td><form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font></td>
                </tr>

                <tr>
                    <td>Password</td>
                    <td><form:password path="pass" size="30" /> <font color="red"><form:errors path="pass"/></font></td>
                </tr>

                <tr>
                    <td>Name:</td>
                    <td><form:input path="name" size="30" /> <font color="red"><form:errors path="name"/></font></td>
                </tr>

                <tr>
                    <td>Gender:</td>
                    <td><form:input path="gender" size="30" /> <font color="red"><form:errors path="gender"/></font></td>
                </tr>

                <tr>
                    <td>Contact No:</td>
                    <td><form:input path="contactNo" size="30" /> <font color="red"><form:errors path="contactNo"/></font></td>
                </tr>

                <tr>
                    <td>Age</td>
                    <td><form:input path="age" size="30" /> <font color="red"><form:errors path="age"/></font></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="Update User Details" /></td>
                </tr>
            </table>
            <br>
        </form:form>
        <a href="userWelcome.htm" style="font-size: 20px; text-decoration: none">Back</a></br></br>
    </body>
</html>
