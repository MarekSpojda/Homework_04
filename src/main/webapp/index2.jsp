<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Task 2</title>
</head>
<body>
<c:forEach var="number" begin="2" end="10" step="2">
    <c:out value="${number}"/><br>
</c:forEach>
</body>
</html>
