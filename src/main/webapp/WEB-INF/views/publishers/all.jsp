<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Wszyscy wydawcy</h1>
<table border="1">
    <thead>
    <tr>
        <td>id</td>
        <td>nazwa</td>
        <td>książki</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${publishers}" var="publisher">
        <tr>
            <td>${publisher.id}</td>
            <td>${publisher.name}</td>

            <td>
                <c:forEach items="${publisher.books}" var="book">
                    ${book.title} ,
                </c:forEach>
            </td>


            <td><a href="/publishers/edit/${publisher.id}">Edytuj wydawcę</a></td>
            <td><a href="/publishers/delete/${publisher.id}" onclick="return confirm
            ('Jesteś pewny, że chcesz usunąć ?')">Usuń wydawcę</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/publishers/add">Dodaj wydawcę</a>
<br><br>
<a href="/">Powrót do strony głównej</a>

</body>
</html>