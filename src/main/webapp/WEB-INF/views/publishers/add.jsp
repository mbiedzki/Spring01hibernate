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
    <h1>Edit publisher</h1>
</div>
<hr>

<div class="w3-container w3-large">
<form:form method="post" modelAttribute="publisher">

    <span style='width: 20%; display: inline-block'>Name : </span> <form:input cssStyle="width: 30%" path="name"/>
    <form:errors path="name" cssClass="error" element="div"/><br><br>
    <span style='width: 20%; display: inline-block'>NIP : </span> <form:input cssStyle="width: 30%" path="nip"/>
    <form:errors path="nip" cssClass="error" element="div"/><br><br>
    <span style='width: 20%; display: inline-block'>REGON : </span> <form:input cssStyle="width: 30%" path="regon"/>
    <form:errors path="regon" cssClass="error" element="div"/><br><br>

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