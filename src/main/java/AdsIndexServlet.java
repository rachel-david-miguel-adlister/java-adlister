import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/ads")
public class AdsIndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Ads adsDao = DaoFactory.getAdsDao();
//        List<Ad> ads = adsDao.all();
//        request.setAttribute("ads", ads);

        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);
    }
}
