import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contacts/show")
public class ContactViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            long id = Long.parseLong(request.getParameter("id"));
            request.setAttribute("contact", DaoFactory.getContactsDao().getContactById(id));
            request.getRequestDispatcher("/contacts-show.jsp").forward(request, response);
        } else {
            response.sendRedirect("/contacts");
        }
    }

}
