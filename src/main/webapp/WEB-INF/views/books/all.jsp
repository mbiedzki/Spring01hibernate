<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Lista książek</h1>

<table border="1">
    <thead>
    <tr>
        <td>id</td>
        <td>tytuł</td>
        <td>rating</td>
        <td>wydawca</td>
        <td>nr wydawcy</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.publisher.name}</td>
            <td>${book.publisher.id}</td>
            <td><a href="/books/edit/${book.id}">Edytuj książkę</a></td>
            <td><a href="/books/delete/${book.id}" onclick="return confirm
            ('Jesteś pewny, że chcesz usunąć ?')">Usuń książkę</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/books/add">Dodaj książkę</a>
</body>
</html>
