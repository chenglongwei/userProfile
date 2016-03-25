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
    Create A New Profile
</h3>

<!-- todo: Modify the action value -->
<c:url var="createProfile" value="/profile/${profile.id}" ></c:url>
<!-- todo: Modify the modelAttribute name -->
<form:form action="${createProfile}" modelAttribute="profile">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="id"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstname">
                    <spring:message text="FirstName"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstname" />
            </td> 
        </tr>
        <tr>
            <td>
                <form:label path="lastname">
                    <spring:message text="LastName"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastname" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="Email"/>
                </form:label>
            </td>
            <td>
                <form:input path="email" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="address">
                    <spring:message text="Address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="organization">
                    <spring:message text="Organization"/>
                </form:label>
            </td>
            <td>
                <form:input path="organization" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="aboutMyself">
                    <spring:message text="AboutMyself"/>
                </form:label>
            </td>
            <td>
                <form:input path="aboutMyself" />
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="<spring:message text="Create"/>" />
            </td>
        </tr>
    </table>
</form:form>


</body>
</html>
