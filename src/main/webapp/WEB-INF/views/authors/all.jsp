<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <td>książki</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>

            <td>
            <c:forEach items="${author.books}" var="book">
                ${book.title} ,
            </c:forEach>
            </td>

            <td><a href="/authors/edit/${author.id}">Edytuj autora</a></td>
            <td><a href="/authors/delete/${author.id}" onclick="return confirm
            ('Jesteś pewny, że chcesz usunąć ?')">Usuń autora</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/authors/add">Dodaj autora</a>

<br><br>
<a href="/">Powrót do strony głównej</a>

</body>
</html>
