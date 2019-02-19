<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dodawanie Wydawcy</h1>

<form:form method="post" modelAttribute="publisher">

    Nazwa wydawnictwa: <form:input path="name"/><br><br>

    <input type="submit" value="Wyślij">

</form:form>
</body>
</html>