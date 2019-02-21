<%--
  Created by IntelliJ IDEA.
  User: michal1
  Date: 2019-02-19
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Strona główna</h1>

<a href="publishers/all" >Wydawcy</a><br><br>
<a href="authors/all" >Autorzy</a><br><br>
<a href="categories/all" >Kategorie</a><br><br>


<a href="books/all" >Książki</a><br><br>
<a href="propositions/add" >Dodawanie propozycji</a><br><br>

<form action="/books/setRating" method="get">
    <input type="number" name="rating">
    <input type="submit" value="rating dla wszystkich">
    </form>


</body>
</html>
