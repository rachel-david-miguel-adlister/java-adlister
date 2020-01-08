<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    // Setting request attribute (this would normally be done in a servlet)
    request.setAttribute("userRole", "admin");

    String message;
    switch (request.getAttribute("userRole").toString()) {
        case "admin":
            message = "administrator";
            break;
        case "s_admin":
            message = "super administrator";
            break;
        case "user_1":
            message = "active user";
            break;
        default:
            message = "unknown status";
    }


    request.setAttribute("userRoleMessage", message);

%>

<html>
<head>
    <title>JSPs: Expression Language</title>
</head>
<body>

    <h1>Your name is: ${param.name}</h1>

<%--  What accessing a user object might eventually look lik in a JSP  --%>
<%--    <h2>Username = ${user.username}</h2>--%>
<%--    <p>User Age = ${user.age}</p>--%>
<%--    <p>User Email = ${user.email}</p>--%>


    <h3>User status: ${userRoleMessage}</h3>


</body>
</html>
