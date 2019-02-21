<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal1
  Date: 2019-02-20
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dodaj Propozycje</h1>

<form:form method="post" modelAttribute="book">

    Tytuł: <form:input path="title"/> <br><br>
    <form:errors path="title" cssClass="error" element="div"/>

    Opis: <form:textarea path="description"/> <br><br>
    <form:errors path="description" cssClass="error" element="div"/>

    <form:hidden path="proposition" value="true" />

    <input type="submit" value="Wyślij">

</form:form>
</body>
</html>
