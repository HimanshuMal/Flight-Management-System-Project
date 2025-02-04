
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import= "java.util.*"%>
<%@ page import="com.mycompany.pojo.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All User Information</title>
    </head>
    <body style="font-family:Consolas, 'Courier New', monospace" align="center">
        <h1 style="border-style:groove; border-color:black; font-size: 35px" align="center">View All User Information</h1>
        <table border ="1" cellpadding="5" cellspacing="5">
            <tr>
                <th>Email</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Contact Number</th>
                <th>Age</th>

            </tr>
            <c:forEach var="adv" items="${userList}">
                <tr>
                    <td>${adv.email}</td>
                    <td>${adv.name}</td>
                    <td>${adv.gender}</td>
                    <td>${adv.contactNo}</td>
                    <td>${adv.age}</td>

                </tr>
            </c:forEach>
        </table>
    </body>
</html>
