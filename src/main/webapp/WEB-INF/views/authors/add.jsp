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
<h1>Dodawanie Autora</h1>

<form:form method="post" modelAttribute="author">

    Imie autora: <form:input path="firstName"/><br><br>
    <form:errors path="firstName" cssClass="error" element="div"/>
    Nazwisko autora: <form:input path="lastName"/><br><br>
    <form:errors path="lastName" cssClass="error" element="div"/>
    PESEL: <form:input path="pesel"/><br><br>
    <form:errors path="pesel" cssClass="error" element="div"/>
    email: <form:input path="email"/><br><br>
    <form:errors path="email" cssClass="error" element="div"/>
    rok urodzenia: <form:input path="yearOfBirth"/><br><br>
    <form:errors path="yearOfBirth" cssClass="error" element="div"/>

    <input type="submit" value="Wyślij">


</form:form>

<br><br>
<a href="/">Powrót do strony głównej</a>
</body>
</html>
