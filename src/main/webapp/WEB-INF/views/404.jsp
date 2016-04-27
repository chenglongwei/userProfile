<%--This directive causes the JSP compiler to generate the exception instance variable.
Otherwise an exception from a DELETE/PUT will be failed, since JSPs only permit GET POST or HEAD --%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>User Profile Exception Handling</title>
</head>
<body>

<h2>404</h2>

<h3>Sorry, the requested user with ID does not exist.</h3>

</body>
</html>