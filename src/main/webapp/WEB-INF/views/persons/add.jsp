<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal1
  Date: 2019-02-19
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dodanie osoby</h1>

<form:form method="post" modelAttribute="person">
    Login : <form:input path="login"/><br>
    Hasło : <form:password path="password"/><br>
    Email : <form:input path="email"/><br>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>
