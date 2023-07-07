
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Flight Data</title>
    </head>
    <body>
        <h1 style="border-style:groove; border-color:black; font-size: 35px" align="center">Add New Flight Data</h1>
        <form:form modelAttribute="flight">
            <table>
                <tr>
                    <td>Flight Number:</td>
                    <td><form:input path="flightNo" size="30" /> <font color="red"><form:errors path="flightNo"/></font></td>
                </tr>

                <tr>
                    <td>Source:</td>
                    <td><form:input path="source" size="30" /> <font color="red"><form:errors path="source"/></font></td>
                </tr>

                <tr>
                    <td>Destination:</td>
                    <td><form:input path="dest" size="30" /> <font color="red"><form:errors path="dest"/></font></td>
                </tr>

                <tr>
                    <td>Total Seats:</td>
                    <td><form:input path="totalSeats" size="30" /> <font color="red"><form:errors path="totalSeats"/></font></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="Add Flight Details" /></td>
                </tr>
            </table>
            <br>
        </form:form>
            <a href="adminWelcome.htm" style="font-size: 20px; text-decoration: none">Back to admin home page</a></br></br>
    </body>
</html>
