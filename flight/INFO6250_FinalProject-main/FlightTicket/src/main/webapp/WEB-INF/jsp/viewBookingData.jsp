
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%@page import="com.mycompany.pojo.Flight" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Tickets</title>
    </head>
    <body style="font-family:Consolas, 'Courier New', monospace" align="left">
        <h1 style="border-style:groove; border-color:black; font-size: 35px" align="center">View Tickets</h1>
        <table border ="1" cellpadding="5" cellspacing="5">
            <tr>
                <th>PNR</th>
                <th>Date</th>
                <th>Adult Count</th>
                <th>Child Count</th>
                <th>Email</th>
                <th>Travel Date</th>
                <th>Flight Number</th>
                
            </tr>
            <c:forEach var="adv" items="${ticketList}">
                <tr>
                    <td>${adv.PNR}</td>
                    <td>${adv.date}</td>
                    <td>${adv.adultCount}</td>
                    <td>${adv.childCount}</td>
                    <td>${adv.email}</td>
                    <td>${adv.travel_date}</td>
                    <td>${adv.flightNo}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="userWelcome.htm" style="font-size: 20px; text-decoration: none">Back to user home page</a>
    </body>
</html>
