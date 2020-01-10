<%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 2020-01-10
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Contact</title>
</head>
<body>

    <h1>${contact.firstName} ${contact.lastName}</h1>
    <p>${contact.phoneNumber}</p>

</body>
</html>
