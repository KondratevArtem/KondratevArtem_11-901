<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <title>VAGODROCH.RU</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>EMAIl</th>
    </tr>
    <#list usersList as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
        </tr>
    </#list>
</table>
</body>
</html>
