<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<p>Formularz wpisu do księgi gości - zapraszamy do wpisu</p>
<form action="${pageContext.request.contextPath}/guest-book" method="POST">
    <label>Imię: <input type="text" name="name"></label><br>
    <label>Nazwisko: <input type="text" name="surname"></label><br>
    <label>Wpis: <input type="text" name="entry"></label><br>
    <input type="submit" value="Wpisz się">
</form>
