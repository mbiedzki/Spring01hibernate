<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {color: red;}
    </style>
</head>
<body>
<h1>Edycja książki</h1>


<form:form method="post" modelAttribute="book">
    <%--błędy u góry<form:errors path="*"/><br><br>--%>

    Tytuł: <form:input path="title"/> <br><br>
    <form:errors path="title" cssClass="error" element="div"/>

    Rating: <form:input path="rating"/> <br><br>
    <form:errors path="rating" cssClass="error" element="div"/>

    Opis: <form:textarea path="description"/> <br><br>
    <form:errors path="description" cssClass="error" element="div"/>

    Liczba stron: <form:input path="pages"/> <br><br>
    <form:errors path="pages" cssClass="error" element="div"/>

    Wydawca: <form:select path="publisher">
    <form:option value="0" label="--Wybierz wydawce--"/>
    <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
</form:select><br><br>
    <form:errors path="publisher" cssClass="error" element="div"/>

    Autor: <form:select path="authors" multiple="true">
    <form:option value="0" label="--Wybierz autorów--"/>
    <form:options items="${authors}" itemLabel="FullName" itemValue="id"/>
</form:select><br><br>
    <form:errors path="authors" cssClass="error" element="div"/>

    <input type="submit" value="Wyślij">

</form:form>

<br><br>
<a href="/">Powrót do strony głównej</a>

</body>
</html>
