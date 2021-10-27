
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>

<h3>Result: </h3>
<p>
    <c:if test="${empty condiments}">
        <span class="message">${requestScope["mess"]}</span>
    </c:if>
</p>
<c:if test="${not empty condiments}">
<c:forEach var="c" items="${condiments}">
    <p>${c.toString()}</p>
</c:forEach>
</c:if>
</body>
</html>
