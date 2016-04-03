<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Group 6: Profile</title>
</head>
<body>
<h1>
    Group 6: Profile
</h1>

<br>
<h3>
    Profile Query Result
</h3>

<pre modelAttribute="profile">
    <c:out value="User ID: ${profile.id}"/>
    <c:out value="First Name: ${profile.firstname}"/>
    <c:out value="Last Name: ${profile.lastname}"/>
    <c:out value="Email: ${profile.email}"/>
    <c:out value="Address: ${profile.address}"/>
    <c:out value="Organization: ${profile.organization}"/>
    <c:out value="AboutMyself: ${profile.aboutMyself}"/>
</pre>


</body>
</html>
