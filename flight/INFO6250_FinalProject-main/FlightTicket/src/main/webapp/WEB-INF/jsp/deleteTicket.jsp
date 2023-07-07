
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancel Flight Ticket</title>
    </head>
    <body style="font-family:Consolas, 'Courier New', monospace" align="left">
        <h1 style="border-style:groove; border-color:black; font-size: 35px" align="center">Cancel Flight Ticket</h1>
        <form:form modelAttribute="ticket">
            <table>
                <tr>
                    <td>Enter your PNR number:</td>
                    <td><form:input path="PNR" size="30" /> <font color="red"><form:errors path="PNR"/></font></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="Cancel" /></td>
                </tr>
            </table>
            <br>
        </form:form>
        <a href="viewAllBookings.htm" style="font-size: 20px; text-decoration: none">Show Tickets</a></br>    
        <a href="userWelcome.htm" style="font-size: 20px; text-decoration: none">Back to home page</a></br></br>
    </body>
</html>
