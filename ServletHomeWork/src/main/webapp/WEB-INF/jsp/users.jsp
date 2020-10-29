<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="my.servlet.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>Users Table</title>
</head>
<body>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">First name</th>
        <th scope="col">Last name</th>
        <th scope="col">Age</th>
        <th scope="col">Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${usersForJsp}" var="user">
        <tr>
            <th scope="row">${user.id}</th>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="container">
    <a class="btn btn-primary btn-lg container"  href="/registration" role="button">Регистрация</a>
</div>
</body>
</html>