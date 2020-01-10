package controllers;

import models.Contact;
import models.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contacts/edit")
public class ContactEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            Contact contactToEdit = DaoFactory.getContactsDao().getContactById(
                    Long.parseLong(request.getParameter("id"))
            );
            System.out.println(contactToEdit);
            request.setAttribute("contact", contactToEdit);
            request.getRequestDispatcher("/contacts/edit.jsp").forward(request, response);
        } else {
            response.sendRedirect("/contacts");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Contact contactToUpdate = new Contact(
                Long.parseLong(request.getParameter("id")),
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("phoneNumber")
        );

        System.out.println(contactToUpdate);

        DaoFactory.getContactsDao().saveContact(contactToUpdate);

        response.sendRedirect("/contacts");

    }
}
