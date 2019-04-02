<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>History</title>
</head>
<body>
Witaj na stronie historii<br>
<form action="${pageContext.request.contextPath}/history" method="POST">
    <input type="submit" value="Wyczyść historię">
</form>
Odwiedzałeś:<br>
<c:if test="${not empty sessionScope.history}">
    <c:forEach var="historyRecord" items="${sessionScope.history}">
        <c:out value="${historyRecord}"/><br>
    </c:forEach>
</c:if>
<c:if test="${empty sessionScope.history}">
    <c:out value="(niczego jeszcze nie odwiedzono)"/><br>
</c:if>
</body>
</html>
