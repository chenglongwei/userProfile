<%--This directive causes the JSP compiler to generate the exception instance variable.
Otherwise an exception from a DELETE/PUT will be failed, since JSPs only permit GET POST or HEAD --%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>User Profile Error</title>
</head>
<body>

<h2>User Profile Error</h2>

<h3>${exception.exceptionMsg}</h3>

</body>
</html>