<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Group 6: Profile</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Group 6: Profile
</h1>

<br>
<h3>
    Profile Query Result
</h3>

<!-- todo: update modelAttribute name and attribute name-->
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
