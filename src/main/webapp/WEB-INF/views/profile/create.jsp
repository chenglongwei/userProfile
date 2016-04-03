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
    Create or Update A New Profile
</h3>

<form id="profileForm" action="/profile" method="post">
    <table>
        <tr>
            <td>
                ID
            </td>
            <td>
                <input type="text" id="id"><br>
            </td>
        </tr>
        <tr>
            <td>
                FirstName
            </td>
            <td>
                <input type="text" name="firstname"><br>
            </td>
        </tr>
        <tr>
            <td>
                LastName
            </td>
            <td>
                <input type="text" name="lastname"><br>
            </td>
        </tr>
        <tr>
            <td>
                Email
            </td>
            <td>
                <input type="text" name="email"><br>
            </td>
        </tr>
        <tr>
            <td>
                Address
            </td>
            <td>
                <input type="text" name="address"><br>
            </td>
        </tr>
        <tr>
            <td>
                Organization
            </td>
            <td>
                <input type="text" name="organization"><br>
            </td>
        </tr>
        <tr>
            <td>
                AboutMyself
            </td>
            <td>
                <input type="text" name="aboutMyself"><br>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create">
            </td>
        </tr>
    </table>
</form>

<form id="hiddenForm" action="/profile" method="post">
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
    // Attach a submit handler to the form
    $("#profileForm").submit(function (event) {
        // Stop form from submitting normally
        event.preventDefault();
        if (!$("#id").val()) {
            //Todo alter
            return;
        }

        var params = {};
        $("#profileForm input").each(function (index) {
            if (this.id != "id" && this.name != "id" && this.type != "submit") {
                params[this.name] = this.value;
            }
        });

        $("#hiddenForm").attr("action", $("#hiddenForm").attr("action") + "/" + $("#id").val() + "?" + $.param(params));
        $("#hiddenForm").submit();
    });
</script>
</body>
</html>
