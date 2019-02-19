<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dane studenta</h1>

<form:form method="post" modelAttribute="student">

    Imie: <form:input path="firstName"/><br><br>
    Nazwisko: <form:input path="lastName"/><br><br>
    M: <form:radiobutton path="gender" value="M"/><br><br>
    K: <form:radiobutton path="gender" value="F"/><br><br>

    <form:select path="country">
        <form:option value="-" label="--Wybierz Kraj--"/>
        <form:options items="${countries}"/>
    </form:select> <br><br>

    <form:textarea path="notes"/><br><br>
    Zgoda: <form:checkbox path="mailingList"/><br><br>

    <form:select path="programmingSkills" multiple="true">
        <form:option value="-" label="--Wybierz Umiejętności--"/>
        <form:options items="${skills}"/>
    </form:select> <br><br>

    Hobby: <form:checkboxes  path="hobbies" items="${hobbies}" /><br><br>

    <input type="submit" value="Wyślij">


</form:form>

</body>
</html>
