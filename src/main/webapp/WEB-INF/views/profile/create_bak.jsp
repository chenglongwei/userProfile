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
    Create A New Profile
</h3>

<form id="profileForm" action="/profile" method="post">
    ID: <input type="text" id="inputId"><br>
    First Name: <input type="text" name="firstname"><br>
    Last Name: <input type="text" name="lastname"><br>
    Email: <input type="text" name="email"><br>
    Address: <input type="text" name="address"><br>
    Organization: <input type="text" name="organization"><br>
    About Myself: <input type="text" name="aboutMyself"><br>
    <input type="submit" value="Create">
</form>

<form id="hiddenForm" action="/profile" method="post"/>

<script type="text/javascript">
    // Attach a submit handler to the form
    $("#profileForm").submit(function(event) {
        // Stop form from submitting normally
        event.preventDefault();
        if (!$("#inputId").val()) {
            //Todo alter
            return;
        }

        var params = {};
        $("#profileForm input").each(function(index) {
            if (this.name != "id" && this.type != "submit") {
                params[this.name] = this.value;
            }
        });

        $("#hiddenForm").attr("action", $("#hiddenForm").attr("action") + "/" + $("#inputId").val() + "?" + $.param(params));
        $("#hiddenForm").submit();
    });
</script>
</body>
</html>
