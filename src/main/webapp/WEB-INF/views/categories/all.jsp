<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal1
  Date: 2019-02-21
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Kategorie</h1>

<table border="1">
    <thead>
    <tr>
        <td>nazwa</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>
                    ${category.name} <br>
            </td>

            <td><a href="/categories/edit/${category.id}">Edytuj kategorię</a></td>
            <td><a href="/categories/delete/${category.id}" onclick="return confirm
            ('Jesteś pewny, że chcesz usunąć ?')">Usuń kategorię</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/categories/add">Dodaj kategorię</a>
<br><br>
<a href="/">Powrót do strony głównej</a>


</body>
</html>
