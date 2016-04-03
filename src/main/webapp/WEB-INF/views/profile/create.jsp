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
    Create A New Profile
</h3>

<form:form action="profile">
    <table>
        <tr>
            <td>
                <form:label path="id"/>
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
                <form:input path="firstname"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="lastname">
                    <spring:message text="LastName"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastname"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="Email"/>
                </form:label>
            </td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="address">
                    <spring:message text="Address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="organization">
                    <spring:message text="Organization"/>
                </form:label>
            </td>
            <td>
                <form:input path="organization"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="aboutMyself">
                    <spring:message text="AboutMyself"/>
                </form:label>
            </td>
            <td>
                <form:input path="aboutMyself"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="<spring:message text="Create"/>"/>
            </td>
        </tr>
    </table>
</form:form>


</body>
</html>
