<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal1
  Date: 2019-02-19
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Wszyscy autorzy</h1>
<table border="1">
    <thead>
    <tr>
        <td>id</td>
        <td>imię</td>
        <td>nazwisko</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href="/authors/edit/${author.id}">Edytuj autora</a></td>
            <td><a href="/authors/delete/${author.id}" onclick="return confirm
            ('Jesteś pewny, że chcesz usunąć ?')">Usuń autora</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/authors/add">Dodaj autora</a>

</body>
</html>
