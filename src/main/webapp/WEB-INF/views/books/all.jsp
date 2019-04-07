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
    <h1>Books</h1>
</div>
<hr>

<div class="w3-container w3-large">
    <table class="w3-table-all">
        <thead>
        <tr class="w3-blue-gray">
            <td>ID</td>
            <td>Title</td>
            <td>Authors</td>
            <td>Publisher</td>
            <td>Category</td>
            <td>Rating</td>
            <td>Status</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>
                    <c:forEach items="${book.authors}" var="author">
                        ${author.fullName} <br>
                    </c:forEach>

                </td>
                <td>${book.publisher.name}</td>
                <td>${book.category.name}</td>
                <td>${book.rating}</td>
                <td>
                    <c:choose>
                        <c:when test="${book.proposition==true}">
                            proposition
                        </c:when>
                        <c:otherwise>
                            printed book
                        </c:otherwise>
                    </c:choose>
                </td>

                <td><a href="/books/edit/${book.id}">Edit</a></td>
                <td><a href="/books/delete/${book.id}" onclick="return confirm
            ('Are you sure that you want to delete ?')">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<hr>
<div class="w3-container">
    <a href="${pageContext.request.contextPath}/books/add"
       class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">New</a>
    <a href="${pageContext.request.contextPath}/"
       class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">Return</a>
</div>

</body>
</html>

