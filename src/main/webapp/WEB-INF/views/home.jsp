<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="w3.css" %>
    </style>
</head>
<body>
<div class="w3-blue-gray w3-container" align="center">
<h1>Simple book management app</h1>
</div>
<hr>

<div class="w3-container" align="center">
<a href="${pageContext.request.contextPath}/publishers/all"
   class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">Publishers</a>
    <a href="${pageContext.request.contextPath}/authors/all"
       class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">Authors</a>
    <a href="${pageContext.request.contextPath}/categories/all"
       class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">Categories</a><hr>
    <a href="${pageContext.request.contextPath}/books/all"
       class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">Books</a>
    <a href="${pageContext.request.contextPath}/propositions/add"
       class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">Propositions</a><hr>
</div>

</body>
</html>
