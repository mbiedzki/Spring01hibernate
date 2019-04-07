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
    <h1>Publishers</h1>
</div>
<hr>

<div class="w3-container w3-large">
    <table class="w3-table-all">
        <thead>
        <tr class="w3-blue-gray">
            <td>ID</td>
            <td>Name</td>
            <td>Books</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${publishers}" var="publisher">
                <tr>
                    <td>${publisher.id}</td>
                    <td>${publisher.name}</td>

                    <td>
                        <c:forEach items="${publisher.books}" var="book">
                            ${book.title} <br>
                        </c:forEach>
                    </td>

                <td><a href="/publishers/edit/${publisher.id}">Edit</a></td>
                <td><a href="/publishers/delete/${publisher.id}" onclick="return confirm
            ('Are you sure that you want to delete ?')">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<hr>
<div class="w3-container">
    <a href="${pageContext.request.contextPath}/publishers/add"
       class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">New</a>
    <a href="${pageContext.request.contextPath}/"
       class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">Return</a>
</div>

</body>
</html>
