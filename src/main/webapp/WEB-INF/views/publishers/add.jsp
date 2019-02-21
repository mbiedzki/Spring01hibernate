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
<h1>Dodawanie Wydawcy</h1>

<form:form method="post" modelAttribute="publisher">

    Nazwa wydawnictwa: <form:input path="name"/><br><br>
    <form:errors path="name" cssClass="error" element="div"/>
    NIP: <form:input path="nip"/><br><br>
    <form:errors path="nip" cssClass="error" element="div"/>
    REGON: <form:input path="regon"/><br><br>
    <form:errors path="regon" cssClass="error" element="div"/>

    <input type="submit" value="Wyślij">

</form:form>

<br><br>
<a href="/">Powrót do strony głównej</a>
</body>
</html>