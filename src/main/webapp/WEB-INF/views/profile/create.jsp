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
<%--<c:url var="createProfile" value="/profile/${id}?firstname=${firstname}&lastname=${lastname}&email=${email}&address=${address}&organization=${organization}&aboutMyself=${aboutMyself}" />--%>
<c:url var="createProfile" value="/profile"+<%=request.getParameter("id")%>?firstname=<%=request.getParameter("firstname")%>" />
<!-- todo: Modify the modelAttribute name -->
<form:form action="${createProfile}" method="post">
    <table>
        <tr>
            <td>
                id
            </td>
            <td>
                <input name="id"/>
            </td>
        </tr>
        <tr>
            <td>
                firstname
            </td>
            <td>
                <input name="firstname" />
            </td>
        </tr>
        <tr>
            <td>
                lastname
            </td>
            <td>
                <input name="lastname" />
            </td>
        </tr>
        <tr>
            <td>
                email
            </td>
            <td>
                <input name="email" />
            </td>
        </tr>
        <tr>
            <td>
                address
            </td>
            <td>
                <input name ="address" />
            </td>
        </tr>
        <tr>
            <td>
                organization
            </td>
            <td>
                <input name="organization" />
            </td>
        </tr>
        <tr>
            <td>
                aboutMyself
            </td>
            <td>
                <input name="aboutMyself" />
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
