<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fruits</title>
</head>
<body>
Fruits:
<br/>
<c:forEach var="fruit" items="${fruits}">
    <c:out value="${fruit}"/>
</c:forEach>
</body>
</html>
