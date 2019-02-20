<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal1
  Date: 2019-02-20
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Walidacje</h1>

<table border="1">
    <thead>
    <tr>
        <td>nazwa pola</td>
        <td>błąd</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${validate}" var="error">
        <tr>
            <td>${error.getPropertyPath()}</td>
            <td>${error.getMessage()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
