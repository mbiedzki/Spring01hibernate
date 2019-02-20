<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edycja książki</h1>

<form:form method="post" modelAttribute="book">
    Tytuł: <form:input path="title"/> <br><br>
    Rating: <form:input path="rating"/> <br><br>
    Opis: <form:textarea path="description"/> <br><br>
    Liczba stron: <form:input path="pages"/> <br><br>

    Wydawca: <form:select path="publisher">
    <form:option value="0" label="--Wybierz wydawce--"/>
    <form:options items="${publishers}" itemLabel="name" itemValue="id" />
    </form:select><br><br>

    Autor: <form:select path="authors">
    <form:option value="0" label="--Wybierz autora--"/>
    <form:options items="${authors}" itemLabel="FullName" itemValue="id" />
    </form:select> <br><br>

    <input type="submit" value="Wyślij">

</form:form>

</body>
</html>
