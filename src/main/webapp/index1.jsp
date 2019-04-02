<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Task 1</title>
</head>
<body>
<c:if test="${not empty param.author}">
    <p>Wybrany autor ${param.author}</p>
</c:if>
</body>
</html>
