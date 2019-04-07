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
    <h1>Edit book</h1>
</div>
<hr>

<div class="w3-container w3-large">

<form:form method="post" modelAttribute="book">

    <span style='width: 20%; display: inline-block'>Title : </span><form:input cssStyle="width: 30%" path="title"/>
    <form:errors path="title" cssClass="error" element="div"/><br><br>

    <span style='width: 20%; display: inline-block'>Rating : </span><form:input cssStyle="width: 30%" path="rating"/>
    <form:errors path="rating" cssClass="error" element="div"/><br><br>

    <span style='width: 20%; display: inline-block; vertical-align: top'>Description : </span><form:textarea cssStyle="width: 30%; height: 8em" path="description"/>
    <form:errors path="description" cssClass="error" element="div"/><br><br>

    <span style='width: 20%; display: inline-block'>Number of pages : </span><form:input cssStyle="width: 30%" path="pages"/>
    <form:errors path="pages" cssClass="error" element="div"/><br><br>

    <span style='width: 20%; display: inline-block'>Publisher : </span><form:select cssStyle="width: 30%"  path="publisher">
    <form:option value="0" label="--Select publisher--"/>
    <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
    </form:select><br><br>
    <form:errors path="publisher" cssClass="error" element="div"/>

    <span style='width: 20%; display: inline-block'>Category : </span><form:select cssStyle="width: 30%"  path="category">
    <form:option value="0" label="--Select category--"/>
    <form:options items="${categories}" itemLabel="name" itemValue="id"/>
    </form:select><br><br>
    <form:errors path="category" cssClass="error" element="div"/>

    <span style='width: 20%; display: inline-block; vertical-align: top'>Authors : </span>
    <form:select cssStyle="width: 30%"  path="authors" multiple="true">
    <form:option value="0" label="--Select authors--"/>
    <form:options items="${authors}" itemLabel="FullName" itemValue="id"/>
    </form:select><br><br>
    <form:errors path="authors" cssClass="error" element="div"/>

    <hr>
    <button type="submit"
            class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">
        Save</button>
    <a href="${pageContext.request.contextPath}/books/all"
       class="w3-button w3-xlarge w3-border w3-border-blue-gray w3-round-xxlarge">Return</a>

</form:form>



</body>
</html>