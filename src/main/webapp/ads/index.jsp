<%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 2020-01-10
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Ads</title>
</head>
<body>

    <h1>Showing All Ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <h2>${ad.title}</h2>
        <p>${ad.description}</p>
    </c:forEach>

</body>
</html>
