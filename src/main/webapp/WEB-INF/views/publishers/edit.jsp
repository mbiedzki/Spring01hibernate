<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edycja Wydawcy</h1>

<form:form method="post" modelAttribute="publisher">

    Nazwa wydawnictwa: <form:input path="name"/><br><br>
    NIP: <form:input path="nip"/><br><br>
    REGON: <form:input path="regon"/><br><br>

    <input type="submit" value="Wyślij">

</form:form>

<br><br>
<a href="/">Powrót do strony głównej</a>
</body>
</html>