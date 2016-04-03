<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Group 6: Profile</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
<h1>
     Group 6: Profile
</h1>

<br>
<h3>
    Profile Query Result
</h3>

<!-- todo: Modify the modelAttribute  -->
<form id="updateForm" action="/profile" modelAttribute="profile">
    <table>
        <tr>
            <td>
                ID
            </td>
            <td>
                <%--<input type="text" id="id" value="${profile.id}" readonly="true"><br>--%>
                <input type="text" id="id" value="${profile.id}"><br>
            </td>
        </tr>
        <tr>
            <td>
                FirstName
            </td>
            <td>
                <input type="text" name="firstname" value="${profile.firstname}"><br>
            </td>
        </tr>
        <tr>
            <td>
                LastName
            </td>
            <td>
                <input type="text" name="lastname" value="${profile.lastname}"><br>
            </td>
        </tr>
        <tr>
            <td>
                Email
            </td>
            <td>
                <input type="text" name="email" value="${profile.email}"><br>
            </td>
        </tr>
        <tr>
            <td>
                Address
            </td>
            <td>
                <input type="text" name="address" value="${profile.address}"><br>
            </td>
        </tr>
        <tr>
            <td>
                Organization
            </td>
            <td>
                <input type="text" name="organization" value="${profile.organization}"><br>
            </td>
        </tr>
        <tr>
            <td>
                AboutMyself
            </td>
            <td>
                <input type="text" name="aboutMyself" value="${profile.aboutMyself}"><br>
            </td>
        </tr>
        <tr>
            <td>
                <input name="update" type="submit" value="Update">
            </td>
            <%--<td>--%>
                <%--&lt;%&ndash;<input name="delete" type="submit" value="Delete">&ndash;%&gt;--%>
                    <%--<input type = "button" id="deleteButton" value = "delete">--%>

            <%--</td>--%>
        </tr>
    </table>
    <%--<div>--%>
        <%--<input type = "button" id="deleteButton" value = "delete">--%>
    <%--</div>--%>
</form>

<form id="updateHiddenForm" action="/userProfile%2D2%2E0/profile" method="post"/>

<form id="deleteHiddenForm" action="/userProfile%2D2%2E0/profile" method="post">
    <input type="hidden" name="_method" value="delete">
</form>

<script type="text/javascript">
    // Attach a submit handler to the form
    $("#updateForm").submit(function(event) {
        // Stop form from submitting normally
        event.preventDefault()
        var params = {};
        $("#updateForm input").each(function(index) {
            if (this.name != "id" && this.type != "submit") {
                params[this.name] = this.value;
            }
        });

        $("#updateHiddenForm").attr("action", $("#updateHiddenForm").attr("action") + "/" + $("#id").val() + "?" + $.param(params));
        $("#updateHiddenForm").submit();
    });

    // Attach a submit handler to the form
//    $("#deleteButton").click(function(event) {
//        // Stop form from submitting normally
//        event.preventDefault();
//        alert("hkk");
//        $("#deleteHiddenForm").attr("action", $("#deleteHiddenForm").attr("action") + "/" + $("#id").val());
//        $("#deleteHiddenForm").submit();
//        alert("aaa");
//    });
</script>

<%--<form id="deleteForm" action="/userProfile%2D2%2E0/profile" method="delete" modelAttribute="profile">--%>
    <%--<td>--%>
        <%--&lt;%&ndash;<input name="delete" type="submit" value="Delete">&ndash;%&gt;--%>
            <%--<input type="hidden" name="_method" value="delete">--%>
    <%--</td>--%>

<%--</form>--%>


</body>
</html>
