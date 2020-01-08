<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 2020-01-08
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<%
    List<String> names = new ArrayList<>();
    names.add("Justin");
    names.add("Trant");
    names.add("Sophie");
    names.add("Vivian");


    boolean isAdmin = false;

    request.setAttribute("isAdmin", isAdmin);
    request.setAttribute("names", names);

//    request.setAttribute("users", users);
//    request.setAttribute("username", username);
//    request.setAttribute("age", 33);
//    request.setAttribute("email", "fred@email.com");
%>

<body>

<%--<c:forEach items="${users}" var="user">--%>
<%--    --%>
<%--    <div>--%>
<%--        <h3>${user.username}</h3>--%>
<%--        <p>${user.bio}</p>--%>
<%--    </div>--%>
<%--    --%>
<%--</c:forEach>--%>


<ul>
    <c:if test="${isAdmin}">
        <div>
            This is secret stuff for the admin
        </div>
    </c:if>

    <c:forEach items="${names}" var="name">
        <li>${name}</li>
    </c:forEach>




</ul>


</body>
</html>
