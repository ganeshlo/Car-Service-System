<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
out.println("dear "+session.getAttribute("sname")+", you have successfully logged in");
%><br>

<a href="carDetails.html">enter your car detail</a><br>
<a href="">edit car details</a><br>
<a href="serviceRequest.html">request for service</a><br>
<a href="serviceStatus.html">check service status</a><br>
</body>
</html>