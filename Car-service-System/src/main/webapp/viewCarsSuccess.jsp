<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.qn.model.Car" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Details</title>
</head>
<body>
    <h1>Car Details</h1>
    <%
        ArrayList<Car> carDetails = (ArrayList<Car>) session.getAttribute("scarDetails");
        if (carDetails != null) {
            for (Car x : carDetails) {
                out.println("<p>" + x + "</p>"); // Assumes Car class has a meaningful toString() method
            }
        } else {
            out.println("<p>No car details found in the session.</p>");
        }
    %>
</body>
</html>
