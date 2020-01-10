<%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 2020-01-10
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Edit</title>
</head>
<body>

    <h1>Edit Contact</h1>

    <form action="/contacts/edit" method="POST">
        <div>
            <label for="firstName">First Name</label>
            <input value="${contact.firstName}" id="firstName" name="firstName" placeholder="Enter first name">
        </div>
        <div>
            <label for="lastName">Last Name</label>
            <input value="${contact.lastName}" id="lastName" name="lastName" placeholder="Enter last name">
        </div>
        <div>
            <label for="phoneNumber">Phone Number</label>
            <input value="${contact.phoneNumber}" id="phoneNumber" name="phoneNumber" type="tel" placeholder="Enter phone number">
        </div>
        <input type="hidden" name="id" value="${contact.id}">
        <button>Submit</button>
    </form>

</body>
</html>
