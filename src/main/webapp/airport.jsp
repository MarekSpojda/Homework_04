<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Task 5</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<form action="${pageContext.request.contextPath}/task5" method="POST">
    <label>Lotnisko wylotu
        <select name="startAirport">");
            <c:forEach var="airport" items="${sessionScope.airports}">
                <option value="${airport.name}">${airport.name}</option>
            </c:forEach>
        </select>
    </label><br>

    <label>Lotnisko przylotu
        <select name="endAirport">");
            <c:forEach var="airport" items="${sessionScope.airports}">
                <option value="${airport.name}">${airport.name}</option>
            </c:forEach>
        </select>
    </label><br>

    <label>Czas startu
        <input type="datetime-local" name="start-time" value="2019-03-30 11:30 AM">
    </label><br>

    <label>Długość lotu w godzinach
        <input type="number" name="flight-time" min="0" step="1" value="0">
    </label><br>

    <label>Cena lotu
        <input type="number" name="price" min="0" step="0.01" value="0">
    </label><br>

    <input type="submit" value="Go!">
</form>
</body>
</html>
