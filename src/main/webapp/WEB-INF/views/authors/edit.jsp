<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal1
  Date: 2019-02-19
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="author">

    Imie autora: <form:input path="firstName"/><br><br>
    Nazwisko autora: <form:input path="lastName"/><br><br>

    <input type="submit" value="Wyślij">


</form:form>

</body>
</html>
