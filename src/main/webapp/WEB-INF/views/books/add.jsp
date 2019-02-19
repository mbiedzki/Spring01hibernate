<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 19.02.19
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Dodaj ksiazke</h1>

<form:form method="post" modelAttribute="book">
    Tytuł: <form:input path="title"/> <br><br>
    Rating: <form:input path="rating"/> <br><br>
    Opis: <form:textarea path="description"/> <br><br>
    Wydawca: <form:select path="publisher">
    <form:option value="0" label="Wybierz wydawce"/>
    <form:options items="${publishers}" itemLabel="name" itemValue="id" />


</form:select> <br><br>


    <input type="submit" value="Wyślij">





</form:form>

</body>
</html>