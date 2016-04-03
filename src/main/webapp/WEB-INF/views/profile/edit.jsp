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

<form id="updateForm" action="/profile" modelAttribute="profile">
    <table>
        <tr>
            <td>
                ID
            </td>
            <td>
                <input type="text" id="id" value="${profile.id}" readonly="true"><br>
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
            <td>
                <div>
                    <input type="button" id="deleteButton" value="delete">
                </div>

            </td>
        </tr>
    </table>

</form>

<form id="updateHiddenForm" action="/profile" method="post">
</form>

<form id="deleteHiddenForm" action="/profile" method="post">
    <input type="hidden" name="_method" value="delete">
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        // Attach a submit handler to the form
        $("#updateForm").submit(function (event) {
            // Stop form from submitting normally
            event.preventDefault();
            var params = {};
            $("#updateForm input").each(function (index) {
                if (this.id != "id" && this.name != "id" && this.type != "submit" && this.type != "button") {
                    params[this.name] = this.value;
                }
            });

            $("#updateHiddenForm").attr("action", $("#updateHiddenForm").attr("action") + "/" + $("#id").val() + "?" + $.param(params));
            $("#updateHiddenForm").submit();
        });

        // Attach a submit handler to the form
        $("#deleteButton").click(function (event) {
            event.preventDefault();
            $("#deleteHiddenForm").attr("action", $("#deleteHiddenForm").attr("action") + "/" + $("#id").val());
            $("#deleteHiddenForm").submit();
        });
    });
</script>

</body>
</html>
