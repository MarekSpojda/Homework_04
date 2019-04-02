<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Task 3</title>
</head>
<body>
<c:set var="someName" value="Witaj w coderslab."/>
<c:if test="${fn:contains(someName, 'coderslab')}">
    <p>OK</p>
</c:if>
</body>
</html>
