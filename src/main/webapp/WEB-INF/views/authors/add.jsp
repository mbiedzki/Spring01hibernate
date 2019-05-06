<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="../w3.css" %>
        <%@include file="../style.css" %>
    </style>
</head>
<body>
<div class="w3-blue-gray w3-container" align="center">
    <h2>Simple book management app</h2>
    <h1>Edit author</h1>
</div>
<hr>

<div class="w3-container w3-large">
    <form:form method="post" modelAttribute="author">

        <span style='width: 20%; display: inline-block'>First name : </span>
        <form:input cssStyle="width: 30%" path="firstName"/>
        <form:errors path="firstName" cssClass="error" element="div"/><br><br>
        <span style='width: 20%; display: inline-block'>Last name : </span><form:input cssStyle="width: 30%" path="lastName"/>
        <form:errors path="lastName" cssClass="error" element="div"/><br><br>
        <span style='width: 20%; display: inline-block'>PESEL : </span><form:input cssStyle="width: 30%" path="pesel"/>
        <form:errors path="pesel" cssClass="error" element="div"/><br><br>
        <span style='width: 20%; display: inline-block'>Email : </span><form:input cssStyle="width: 30%" path="email"/>
        <form:errors path="email" cssClass="error" element="div"/><br><br>
        <span style='width: 20%; display: inline-block'>Year of birth : </span><form:input path="yearOfBirth"/>
        <form:errors path="yearOfBirth" cssClass="error" element="div"/><br><br>

        <hr>
        <button type="submit"
                class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">
            Save
        </button>
        <a href="${pageContext.request.contextPath}/authors/all"
           class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">Return</a>


    </form:form>
</div>

</body>
</html>
