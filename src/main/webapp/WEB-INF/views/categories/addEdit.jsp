<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal1
  Date: 2019-02-21
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {color: red;}
    </style>
</head>
<body>
<h1>Dodanie lub edycja kategorii</h1>

<form:form method="post" modelAttribute="category">

    Tytuł: <form:input path="name"/> <br><br>
    <form:errors path="name" cssClass="error" element="div"/>

    <input type="submit" value="Wyślij">

</form:form>


</body>
</html>
