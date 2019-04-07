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
    <h1>Simple book management app</h1>
    <h1>Add publisher</h1>
</div>
<hr>

<div class="w3-container w3-xlarge">
<form:form method="post" modelAttribute="publisher">

    <span style='width: 8em; display: inline-block'>Name : </span> <form:input path="name"/><br>
    <form:errors path="name" cssClass="error" element="div"/><br>
    <span style='width: 8em; display: inline-block'>NIP : </span> <form:input path="nip"/><br>
    <form:errors path="nip" cssClass="error" element="div"/><br>
    <span style='width: 8em; display: inline-block'>REGON : </span> <form:input path="regon"/><br>
    <form:errors path="regon" cssClass="error" element="div"/><br>

    <hr>
    <button type="submit"
            class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">
        Save</button>
    <a href="${pageContext.request.contextPath}/publishers/all"
       class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">Return</a>

</form:form>
</div>
</body>
</html>