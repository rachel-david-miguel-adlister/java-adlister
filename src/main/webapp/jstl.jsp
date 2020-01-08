<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 8/19/18
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- taglib directive for bringing in a library (JSP Standard Tag Library) --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%

    request.setAttribute("lactoseIntolerant", false);

    List<String> dairyProducts = new ArrayList<>();
    dairyProducts.add("Yogurt");
    dairyProducts.add("Milk");
    dairyProducts.add("Chedder");
    dairyProducts.add("Cottage Cheese");
    dairyProducts.add("Queso");
    request.setAttribute("dairyProducts", dairyProducts);


    request.setAttribute("mainMessage", "JSTL Lecture");

    request.setAttribute("isAdmin", false);

    request.setAttribute("age", 20);

%>
<html>
<head>
    <title>JSPs: JSTL</title>
</head>
<body>

    <h1>${mainMessage}</h1>

    <c:if test="${isAdmin}">
        <h3>Secret admin stuff!</h3>
    </c:if>


    <c:choose>

        <c:when test="${lactoseIntolerant}">
            <h3>No Dairy</h3>
        </c:when>
        <c:otherwise>
            <h3>Dairy Product List</h3>
            <c:forEach items="${dairyProducts}" var="dairyProduct">
                <div>
                    <p>${dairyProduct}</p>
                </div>
            </c:forEach>
        </c:otherwise>

    </c:choose>


    <c:choose>

        <c:when test='${param.color.equals("blue")}'>
            <p style="color:blue">BLUE!</p>
        </c:when>
        <c:when test="${param.color.equals(\"red\")}">
            <p style="color:red">RED!</p>
        </c:when>
        <c:when test="${param.color.equals(\"red\")}">
            <p style="color:yellow">YELLOW!</p>
        </c:when>

    </c:choose>


</body>

</html>
