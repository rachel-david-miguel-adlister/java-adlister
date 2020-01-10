<%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 2020-01-10
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>

    <h1>Contacts Page</h1>

    <h2>All Contacts</h2>
    <c:forEach var="contact" items="${contacts}">
        <h1>${contact.firstName} ${contact.lastName}</h1>
        <p>${contact.phoneNumber}</p>
        <a href="${'/contacts/show?id='.concat(contact.id)}">View Contact</a>
        <form action="/contacts/delete" method="POST">
            <input type="hidden" value="${contact.id}" name="id">
            <button>Delete</button>
        </form>
        <a href="${'/contacts/edit?id='.concat(contact.id)}">Edit</a>
    </c:forEach>

    <h2>Add Contact</h2>
    <form action="/contacts/create" method="POST">
        <div>
            <label for="firstName">First Name</label>
            <input id="firstName" name="firstName" placeholder="Enter first name">
        </div>
        <div>
            <label for="lastName">Last Name</label>
            <input id="lastName" name="lastName" placeholder="Enter last name">
        </div>
        <div>
            <label for="phoneNumber">Phone Number</label>
            <input id="phoneNumber" name="phoneNumber" type="tel" placeholder="Enter phone number">
        </div>
        <button>Submit</button>
    </form>

</body>
</html>
