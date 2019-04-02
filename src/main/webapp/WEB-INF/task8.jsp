<!DOCYTPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Task 8</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sagittis rutrum efficitur. Cras viverra convallis enim
    sit amet porta. Quisque consequat velit massa, vitae feugiat sapien convallis eget. Sed ultricies dignissim nunc,
    sed vehicula enim feugiat eget. Ut sit amet neque eu magna pulvinar facilisis. Integer vitae rhoncus orci, vitae
    auctor risus. Donec porttitor justo quis purus dictum, eget condimentum orci ullamcorper. Praesent mollis sem purus,
    a egestas magna sollicitudin et. Nunc nec risus at nisl tristique mattis. Morbi aliquam diam sit amet efficitur
    tincidunt. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc consectetur
    nisi quam, luctus blandit nisi euismod vitae. In vitae blandit lacus, non dictum odio. Integer a elementum metus,
    sit amet pretium leo. Nullam bibendum, felis vitae congue gravida, nibh augue luctus enim, sit amet varius dui
    tortor ac urna. Mauris cursus neque quam, ac porta erat tincidunt non.</p>

<c:if test="${sessionScope.displayForm==true}">
    <form action="${pageContext.request.contextPath}/newsletter" method="POST">
        <label>Imię i nazwisko: <input type="text" name="name"></label><br>
        <label>E-mail: <input type="text" name="email"></label><br>
        <input type="submit" value="Continue">
    </form>
</c:if>

</body>
</html>
